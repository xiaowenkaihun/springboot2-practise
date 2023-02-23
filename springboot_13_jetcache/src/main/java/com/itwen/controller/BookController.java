package com.itwen.controller;

import com.alicp.jetcache.anno.Cached;
import com.itwen.pojo.Book;
import com.itwen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public boolean update(@RequestBody  Book book){
        return bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return bookService.delete(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Book book){
       return bookService.insert(book);
    }
}
