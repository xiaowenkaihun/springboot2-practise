package com.itwen.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/22 10:33
 * 文件描述：
 */
@RestController
@RequestMapping("/boot")
public class SpringController {
    @GetMapping
    public String getById(){
        return "springboot is running...";
    }
}
