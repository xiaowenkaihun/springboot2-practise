package com.itwen.contoller;

import com.itwen.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    // 读取yml中的单一数据
    @Value("${country}")
    private String country1;
    @Value("${user.name}")
    private String name1;
    @Value("${likes[2]}")
    private String likes2;
    @Value("${tempDir}")
    private String tempDir;
    // 使用自动装配，把所有的yml的数据装配到Environment对象当中
    @Autowired
    private Environment environment;

    @Autowired
    private MyDataSource myDataSource;
    @GetMapping
    public String getById() {
        System.out.println("country1===>"+country1);
        System.out.println("name1===>"+name1);
        System.out.println("likes===>"+likes2);
        System.out.println("tempDir===>"+tempDir);
        System.out.println("===============");
        System.out.println(environment.getProperty("user.name"));
        System.out.println("===============");
        System.out.println(myDataSource);
        return "springboot copy project is running...";
    }
}
