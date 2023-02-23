package com.itwen.controller;

import com.itwen.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/10 15:11
 * 文件描述：
 */
@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;

    @GetMapping("/{tel}")
    public String getCode(@PathVariable String tel){
        return msgService.get(tel);
    }

    @PostMapping
    public boolean check(String tel, String code){
        return msgService.check(tel, code);
    }
}
