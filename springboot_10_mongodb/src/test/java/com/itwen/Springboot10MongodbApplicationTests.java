package com.itwen;

import com.itwen.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot10MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testSave() {
        Book book = new Book();
        book.setId(3);
        book.setName("springboot31");
        book.setType("spring3");
        book.setDescription("springboot13");
        mongoTemplate.save(book);
    }

    @Test
    void testFindAll(){
        List<Book> books = mongoTemplate.findAll(Book.class);
        books.forEach(System.out::println);
    }

}
