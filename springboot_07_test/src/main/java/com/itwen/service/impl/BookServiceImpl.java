package com.itwen.service.impl;

import com.itwen.dao.BookDao;
import com.itwen.pojo.Book;
import com.itwen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/6 11:15
 * 文件描述：
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public boolean save(Book book) {
        return bookDao.insert(book)>0;
    }
}
