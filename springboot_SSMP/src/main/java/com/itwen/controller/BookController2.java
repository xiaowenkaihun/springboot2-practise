package com.itwen.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itwen.controller.utils.R;
import com.itwen.pojo.Book;
import com.itwen.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/24 19:51
 * 文件描述：
 */
@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService iBookService;

    @RequestMapping
    public R getAll() {
        return new R(true, iBookService.list());
    }

    @RequestMapping(method = RequestMethod.POST)
    public R save(@RequestBody Book book) {
        return new R(iBookService.save(book));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public R update(@RequestBody Book book) {
        return new R(true, iBookService.updateById(book));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public R toUpdate(@PathVariable Integer id) {
        return new R(true, iBookService.getById(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public R delete(@PathVariable("id") Integer id) {
        return new R(true, iBookService.removeById(id));
    }

    @RequestMapping(value = "/{currentPage}/{pageSize}", method = RequestMethod.GET)
    public R getByPage(@PathVariable("currentPage") Integer currentPage,
                       @PathVariable("pageSize") Integer pageSize,
                       Book book) {
        System.out.println(book);
        IPage<Book> page = iBookService.getPage(currentPage, pageSize, book);
        System.out.println(page.getRecords());
        Page<Book> page1 = new Page<>(currentPage, pageSize);
        return new R(true, page);
    }
}