package com.itwen;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itwen.dao.BookDao;
import com.itwen.pojo.Book;
import net.sf.jsqlparser.statement.create.index.CreateIndex;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.directory.SearchResult;
import java.util.List;


@SpringBootTest
class SpringbootESTest {
    @Autowired
    private BookDao bookDao;
//    @Autowired
//    private ElasticsearchRestTemplate template;

    @Autowired
    private RestHighLevelClient highLevelClient;

    @Test
    void fn() throws Exception{
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        highLevelClient = new RestHighLevelClient(builder);
        highLevelClient.close();
    }

    @Test
    void testCreateIndex() throws Exception{
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        highLevelClient = new RestHighLevelClient(builder);
        CreateIndexRequest request = new CreateIndexRequest("books");
        highLevelClient.indices().create(request, RequestOptions.DEFAULT);
        highLevelClient.close();
    }

    @Test
    void testSpringBootCreateIndex() throws Exception{
        CreateIndexRequest request = new CreateIndexRequest("students");
        highLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    void testSpringBootCreateIndexByIK() throws Exception{
        CreateIndexRequest request = new CreateIndexRequest("books");
        String json = "{\n" +
                "    \"mappings\": {\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"type\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"                \n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        // 设置请求的参数
        request.source(json, XContentType.JSON);
        highLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }


    @Test
    void testCreateDoc() throws Exception{
        // Book book = bookDao.selectById(2);
        List<Book> list = bookDao.selectList(null);
        BulkRequest bulkRequest = new BulkRequest();
        for (Book book:
            list) {
            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
            String json = JSON.toJSONString(book);
            request.source(json, XContentType.JSON);
            bulkRequest.add(request);
        }
        highLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
    }

    @Test
    void testGetById() throws Exception{
        GetRequest getRequest = new GetRequest("books", "2");
        GetResponse response = highLevelClient.get(getRequest, RequestOptions.DEFAULT);
        String json = response.getSourceAsString();
        System.out.println(json);
    }

    @Test
    void testGetAll() throws Exception{
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source();
        SearchResponse re = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = re.getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            Book book = JSON.parseObject(sourceAsString, Book.class);
            System.out.println(book);
        }
    }

    @Test
    void testGetByCondition() throws Exception{
        SearchRequest searchRequest = new SearchRequest("books");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("all", "小说"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse re = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = re.getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            Book book = JSON.parseObject(sourceAsString, Book.class);
            System.out.println(book);
        }
    }


}
