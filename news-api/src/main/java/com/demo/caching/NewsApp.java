package com.demo.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class NewsApp {
    public static void main(String[] args) {
        SpringApplication.run(NewsApp.class, args);
    }
}