package com.itwen;

import com.itwen.config.MyConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
*作者：24岁没牵过女人的手
*日期：2022/12/5 18:06
*文件描述：
*/
@SpringBootTest
@Import(MyConfig.class)
public class ConfigurationTest {
    @Autowired
    private String msg;
    @Test
    void testConfiguration(){
        System.out.println(msg);
    }

}
