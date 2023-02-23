package com.itwen.service.impl;

import com.itwen.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 14:49
 * 文件描述：简单邮件的发送
 */
// @Service
public class SendMailImpl implements SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    // 发送人
    private  String from = "1935431430@qq.com";
    // 接收人
    private  String to = "wenjunazi@163.com";
    // 标题
    private String subject = "测试邮件";
    // 正文
    private String text = "测试邮件的正文内容";
    @Override
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from+"(小甜甜)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
