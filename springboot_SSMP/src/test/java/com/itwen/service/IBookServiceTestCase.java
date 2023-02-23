package com.itwen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itwen.dao.BookDao;
import com.itwen.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/26 10:42
 * 文件描述：
 */
@SpringBootTest
public class IBookServiceTestCase {
    @Autowired
    private IBookService iBookService;

    @Test
    void testGetById(){
        System.out.println(iBookService.getById(2));
    }

    @Test
    void  testGetAll(){
        System.out.println(iBookService.list());
    }

    @Test
    void testGetByPage(){
        Page<Book> page = new Page<>(1, 3);
        Page<Book> page1 = iBookService.page(page);
        List<Book> records = page1.getRecords();
        records.forEach(System.out::println);
    }
}
