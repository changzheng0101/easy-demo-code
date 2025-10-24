package com.weixiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author changzheng
 * @date 2025年10月24日 15:55
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.weixiao.mapper"})
public class SpringTestDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringTestDemo.class);
    }
}
