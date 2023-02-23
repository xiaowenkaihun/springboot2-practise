package com.itwen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/6 10:47
 * 文件描述：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String  name;
    private String type;
    private String description;
}
