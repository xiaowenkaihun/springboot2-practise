package com.itwen.service.impl;

import com.itwen.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 14:49
 * 文件描述：
 */
@Service
public class SendMailImpl1 implements SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    // 发送人
    private  String from = "1935431430@qq.com";
    // 接收人
    private  String to = "wenjunazi@163.com";
    // 标题
    private String subject = "测试邮件";
    // 正文
    private String text = "<a href='https://www.bilibili.com/'>打开B站</a>";
    @Override
    public void sendMail() throws MessagingException {
//        message.setFrom(from+"(小甜甜)");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        try {
            messageHelper.setFrom(from+"(小甜甜)");
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(text, true);

            // 添加附件
            File f1 = new File("D:\\壁纸\\jinx\\1099904.jpg");
            File f2 = new File("D:\\谷歌下载\\学年鉴定.doc");
            messageHelper.addAttachment("壁纸一个", f1);
            messageHelper.addAttachment("学年鉴定表", f2);
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
