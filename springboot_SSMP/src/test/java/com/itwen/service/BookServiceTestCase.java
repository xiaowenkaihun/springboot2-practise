package com.itwen.service;

import com.itwen.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/26 10:31
 * 文件描述：
 */
@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;
    @Test
    void testById(){
        Book book = bookService.getById(2);
        System.out.println(book);
    }
}
