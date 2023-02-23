package com.itwen.service.impl;

import com.alicp.jetcache.anno.*;
import com.itwen.dao.BookDao;
import com.itwen.pojo.Book;
import com.itwen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

/*    private HashMap<Integer, Book> cache = new HashMap<Integer, Book>();*/
    @Override
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    @CacheRefresh(refresh = 10)
    public boolean update(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    @Cached(name = "book_", key = "#id", expire = 3600, cacheType = CacheType.REMOTE)
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
    public boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public boolean insert(Book book) {
        return bookDao.insert(book)>0;
    }

/*    public Book getById(Integer id){
        // 如果当前缓存当中没有要查询的数据，则进行查询，否则直接从缓存当中进行返回
        Book book = cache.get(id);
        if(book==null){
            Book queryBook = bookDao.selectById(id);
            cache.put(id, queryBook);
            return queryBook;
        }
        return book;
    }*/
}
