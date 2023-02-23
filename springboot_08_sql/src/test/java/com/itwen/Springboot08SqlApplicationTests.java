package com.itwen;

import com.itwen.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot08SqlApplicationTests {

    @Test
    void testJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate){
        String sql = "select * from tb_book";
        /*List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);*/
        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("naem"));
                book.setType( rs.getString("type"));
                book.setDescription(rs.getString("description")
                );
                return book;
            }
        };
        List<Book> list = jdbcTemplate.query(sql, rm);
        list.forEach(System.out::println);
    }

    @Test
    void testJdbcTemplateSave(@Autowired JdbcTemplate jdbcTemplate){
        String sql = "insert into tb_book values (4, 'springboot4', 'springboot4', 'springboot4')";
        int update = jdbcTemplate.update(sql);
        System.out.println(update);
    }

}

