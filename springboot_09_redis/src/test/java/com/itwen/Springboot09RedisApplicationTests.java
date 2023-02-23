package com.itwen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Springboot09RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testSet(){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age", 41);
    }

    @Test
    void testGet(){
        ValueOperations ops = redisTemplate.opsForValue();
        Object age = ops.get("age");
        System.out.println(age);
    }
    @Test
    void testHSet(){
        HashOperations hashops = redisTemplate.opsForHash();
        hashops.put("info", "a", "a1");
        hashops.put("info", "b", "b1");
    }
    @Test
    void testHGet(){
        HashOperations hashops = redisTemplate.opsForHash();
        Object o = hashops.get("info", "b");
        System.out.println(o);
    }

}
