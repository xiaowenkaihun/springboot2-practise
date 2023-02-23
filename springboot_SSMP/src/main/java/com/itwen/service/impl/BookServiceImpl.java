package com.itwen.service.impl;

import com.itwen.dao.BookDao;
import com.itwen.pojo.Book;
import com.itwen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/26 10:27
 * 文件描述：
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
