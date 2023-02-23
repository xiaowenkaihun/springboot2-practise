package com.itwen;

import com.itwen.testcase.pojo.BookCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
/**
*作者：24岁没牵过女人的手
*日期：2022/12/5 18:06
*文件描述：
*/

// properties可以为当前的测试添加临时属性
// @SpringBootTest(properties = {"test.prop=value1"})
@SpringBootTest(args = {"--test.prop=value2"})
public class PropertiesAndArgsTest {
    @Value("${test.prop}")
    private String msg;
    @Autowired
    private BookCase bookCase;
    @Test
    void testProperties(){
        System.out.println(msg);
        System.out.println(bookCase);
    }

}
