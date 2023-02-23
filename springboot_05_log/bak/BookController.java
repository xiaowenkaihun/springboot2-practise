package com.itwen.controller.bak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/11/29 10:48
 * 文件描述：
 */
@RestController
@RequestMapping("/books")
public class BookController extends BaseClass {
    // private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public String getById(){
        logger.debug("debug...");
        logger.info("info....");
        logger.warn("warn...");
        logger.error("error...");
        return "spring is running";
    }
}
