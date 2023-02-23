package com.itwen.service;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/10 15:06
 * 文件描述：
 */
public interface MsgService {
    public String get(String tel);
    public  boolean check(String tel, String code);
}
