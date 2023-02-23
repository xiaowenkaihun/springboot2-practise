package com.itwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Springboot15TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot15TaskApplication.class, args);
    }

}
