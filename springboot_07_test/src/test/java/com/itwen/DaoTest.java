package com.itwen;

import com.itwen.dao.BookDao;
import com.itwen.pojo.Book;
import com.itwen.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/6 11:17
 * 文件描述：
 */
@SpringBootTest
@Transactional
@Rollback(value = false)
public class DaoTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao bookDao;

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("水浒传");
        book.setType("小说");
        book.setDescription("这是四大名著之一");
        bookService.save(book);
    }

    @Test
    void testDao(){
        Book book = bookDao.selectById(2);
        System.out.println(book);
    }
}
