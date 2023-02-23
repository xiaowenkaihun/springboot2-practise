package com.itwen.service;

import com.itwen.pojo.Book;

import java.util.List;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/26 10:22
 * 文件描述：
 */
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();

}
