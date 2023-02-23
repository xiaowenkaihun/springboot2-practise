package com.itwen;

import com.itwen.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class Springboot16MailApplicationTests {
    @Autowired
    private SendMailService sendMailService;

    @Test
    void contextLoads() throws MessagingException {
        sendMailService.sendMail();
    }

}
