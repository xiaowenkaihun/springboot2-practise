package com.itwen.controller.bak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/29 11:05
 * 文件描述：
 */
public class BaseClass {
    private Class claszz;
    public static Logger logger;

    public BaseClass(){
        claszz = this.getClass();
        logger = LoggerFactory.getLogger(claszz);
    }
}
