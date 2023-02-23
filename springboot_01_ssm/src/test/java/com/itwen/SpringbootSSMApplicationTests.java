package com.itwen;
// 测试类要和引导类要在同一个包下面

import com.itwen.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootSSMApplication.class)
// 也可以通过classes属性找到引导类
class SpringbootSSMApplicationTests {
    // 注入要测试的对象
    @Autowired
    private BookDao bookDao;


    @Test
    void contextLoads() {
        System.out.println("test...");
        bookDao.save();
    }

}
