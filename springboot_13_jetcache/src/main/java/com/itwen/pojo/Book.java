package com.itwen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/6 10:47
 * 文件描述：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private Integer id;
    private String  name;
    private String type;
    private String description;
}
