package com.weixiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author changzheng
 * @date 2025年11月04日 11:10
 */
@SpringBootApplication
@EnableAsync
public class AsyncDemo {
    public static void main(String[] args) {
        SpringApplication.run(AsyncDemo.class);
    }
}
