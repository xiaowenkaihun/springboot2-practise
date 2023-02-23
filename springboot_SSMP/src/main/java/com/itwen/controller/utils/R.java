package com.itwen.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/26 15:53
 * 文件描述：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private Boolean flag;
    private Object data;

    public R(Boolean flag){
        this.flag = flag;
    }
}
