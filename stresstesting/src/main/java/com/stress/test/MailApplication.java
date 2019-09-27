package com.stress.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
public class MailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class, args);
    }

}
