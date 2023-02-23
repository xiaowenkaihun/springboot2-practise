package com.itwen.controller;

import com.itwen.pojo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/6 10:15
 * 文件描述：
 */
@RestController
@RequestMapping("/books")
public class BookController {
//    @GetMapping
//    public String getById(){
//        System.out.println("get by id is running");
//        return "spring is running";
//    }

    @GetMapping
    public Book getById(){
        Book book = new Book();
        book.setId(2);
        book.setName("水浒传");
        book.setType("小说");
        book.setDescription("这是四大名著之一");
        System.out.println("get by id is running");
        return book;
    }
}
