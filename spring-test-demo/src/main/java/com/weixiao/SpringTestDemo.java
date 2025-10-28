package com.weixiao;

import com.weixiao.domain.Tool;
import jakarta.annotation.Resource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author changzheng
 * @date 2025年10月24日 15:55
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.weixiao.mapper"})
public class SpringTestDemo implements ApplicationRunner {

    @Autowired
    SingleToolFactory singleToolFactory;

    public static void main(String[] args) {
        SpringApplication.run(SpringTestDemo.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(singleToolFactory.getObject());
    }
}
