package com.itwen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itwen.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/24 18:49
 * 文件描述：
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
