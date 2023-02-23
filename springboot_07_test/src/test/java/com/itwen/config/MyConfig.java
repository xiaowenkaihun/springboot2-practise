package com.itwen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/6 9:59
 * 文件描述：
 */
@Configuration
public class MyConfig {
    @Bean
    public String msg(){
        return "msg bean";
    }
}
