package com.itwen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itwen.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/6 11:10
 * 文件描述：
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
