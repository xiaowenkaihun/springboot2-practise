package com.itwen.controller;

import com.itwen.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 16:23
 * 文件描述：
 */
@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public String doMessage(){
        return messageService.doMessage();
    }
}
