package com.itwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Springboot12CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot12CacheApplication.class, args);
    }

}
