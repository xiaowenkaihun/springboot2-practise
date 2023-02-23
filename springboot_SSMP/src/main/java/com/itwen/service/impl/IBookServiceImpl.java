package com.itwen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itwen.dao.BookDao;
import com.itwen.pojo.Book;
import com.itwen.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/26 10:39
 * 文件描述：
 */
@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize, Book book) {
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        IPage<Book> page = new Page<Book>(currentPage, pageSize);
        return bookDao.selectPage(page, lambdaQueryWrapper);
    }
}
