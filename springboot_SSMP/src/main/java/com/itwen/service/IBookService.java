package com.itwen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itwen.pojo.Book;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/26 10:38
 * 文件描述：
 */
public interface IBookService extends IService<Book> {
    IPage<Book> getPage(Integer currentPage, Integer pageSize, Book book);
}
