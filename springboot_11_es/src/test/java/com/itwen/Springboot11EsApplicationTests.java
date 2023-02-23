package com.itwen;

import com.itwen.dao.BookDao;
import com.itwen.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot11EsApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void fn(){
        Book book = bookDao.selectById(2);
        System.out.println(book);
    }

    @Test
    void contextLoads() {
    }

}
