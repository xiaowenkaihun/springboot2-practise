package com.itwen.dao.impl;

import com.itwen.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/24 16:19
 * 文件描述：
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao is running...");
    }
}
