package com.itwen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/24 18:47
 * 文件描述：
 */
@Component
@Data()
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_book")
public class Book {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String type;
    private String name;
    private String description;
}
