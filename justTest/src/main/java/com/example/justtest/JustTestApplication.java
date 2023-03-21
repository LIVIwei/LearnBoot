package com.example.justtest;

import com.example.justtest.annotation.EnableCustomConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCustomConfig
public class JustTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustTestApplication.class, args);
    }
}
