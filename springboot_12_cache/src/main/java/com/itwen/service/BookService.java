package com.itwen.service;

import com.itwen.pojo.Book;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/6 11:14
 * 文件描述：
 */
public interface BookService {
    boolean save(Book book);

    Book getById(Integer id);
}
