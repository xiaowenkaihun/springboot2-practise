package com.itwen.controller;

import com.itwen.pojo.Book;
import com.itwen.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/24 19:51
 * 文件描述：
 */
// @RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @RequestMapping
    public List<Book> getAll(){
        return iBookService.list();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boolean save(@RequestBody Book book){
        return iBookService.save(book);
    }
}
