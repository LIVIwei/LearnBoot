package com.example.livi;

import com.example.livi.annotation.EnableCustomConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCustomConfig
public class LiviApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiviApplication.class, args);
    }

}
