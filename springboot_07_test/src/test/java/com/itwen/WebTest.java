package com.itwen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/6 10:08
 * 文件描述：
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class WebTest {
    @Test
    void test(){

    }
    @Test
    void testMvc(@Autowired MockMvc mvc) throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        mvc.perform(builder);
    }

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books1");
        ResultActions actions = mvc.perform(builder);

        // 设定预期值与真实值进行比较，如果相同就表明测试通过
        // 定义预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 预计本次调用成功的状态是200
        ResultMatcher ok = status.isOk();
        // 添加预计值到本次调用过程中进行匹配
        // 函数中自带断言
        actions.andExpect(ok);
    }

    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher resultMatcher = content.string("springboot");
        actions.andExpect(resultMatcher);
    }

    @Test
    void testJson(@Autowired MockMvc mvc) throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions actions = mvc.perform(builder);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher resultMatcher = content.json("{\"id\":1,\"name\":\"水浒传\",\"type\":\"小说\",\"description\":\"这是四大名著之一\"}");
        actions.andExpect(resultMatcher);
    }
}
