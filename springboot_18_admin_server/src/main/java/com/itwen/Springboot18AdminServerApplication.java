package com.itwen;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class Springboot18AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot18AdminServerApplication.class, args);
    }

}
