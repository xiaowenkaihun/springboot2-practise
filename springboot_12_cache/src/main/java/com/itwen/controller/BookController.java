package com.itwen.controller;

import com.itwen.pojo.Book;
import com.itwen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }
}
