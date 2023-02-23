package com.itwen.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/29 10:48
 * 文件描述：
 */
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController{

    @GetMapping
    public String getById(){
        log.debug("debug...");
        log.info("info....");
        log.warn("warn...");
        log.error("error...");
        return "spring is running";
    }
}
