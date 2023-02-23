package com.itwen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringbootRedisTemplateTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void get(){
        ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();
        String name = stringValueOperations.get("name");
        System.out.println(name);
    }

}
