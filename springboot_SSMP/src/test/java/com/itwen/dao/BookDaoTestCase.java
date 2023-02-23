package com.itwen.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itwen.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;
    @Test
    void testById() {
        System.out.println(bookDao.getById(2));
        System.out.println(bookDao.selectById(2));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setName("红楼梦");
        book.setType("长篇小说");
        book.setDescription("这是一篇长篇小说");
        int result = bookDao.insert(book);
        System.out.println("影响的行数===>"+result);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(2);
        book.setName("红楼梦");
        book.setType("长篇小说");
        book.setDescription("这是一篇曹雪芹写的长篇小说");
        bookDao.updateById(book);
    }

    @Test
    void testGetAll(){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        List<Book> books = bookDao.selectList(null);
        books.forEach(System.out::println);
    }

    @Test
    void testGetByCondition(){
        String name = null;
        // QueryWrapper<Book> wrapper = new QueryWrapper<Book>();
        // wrapper.eq("id", 2).select("name");
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name!=null, Book::getName, name);
        // id = 2， 只查询name
        List<Book> books = bookDao.selectList(lambdaQueryWrapper);
        books.forEach(System.out::println);
    }

    @Test
    void testGetPage(){
        Page<Book> bookPage = new Page<>(1, 3);
        Page<Book> page1 = bookDao.selectPage(bookPage, null);
        List<Book> records = page1.getRecords();
        System.out.println("第一页数据"+records);
        System.out.println("一共可以分多少页"+page1.getPages());
        System.out.println("当前页是"+page1.getCurrent());
    }
}
