package com.ran.final1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ran.final1.mapper")
public class Final1Application {

    public static void main(String[] args) {
        SpringApplication.run(Final1Application.class, args);
    }

}
