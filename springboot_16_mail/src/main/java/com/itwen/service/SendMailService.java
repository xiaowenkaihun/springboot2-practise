package com.itwen.service;

import javax.mail.MessagingException;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 14:48
 * 文件描述：
 */
public interface SendMailService {
    void sendMail() throws MessagingException;
}
