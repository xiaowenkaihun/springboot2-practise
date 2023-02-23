package com.itwen;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// jetcache启用缓存的开关
@EnableCreateCacheAnnotation
// 开启方法注解缓存
@EnableMethodCache(basePackages = "com.itwen")
public class Springboot13JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot13JetcacheApplication.class, args);
    }

}
