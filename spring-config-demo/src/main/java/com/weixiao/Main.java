package com.weixiao;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author changzheng
 * @date 2025年10月22日 14:31
 */
@SpringBootApplication
// 支持各种格式的配置，需要在这里指定@Value注解才能扫到
@PropertySources(value = {
        @PropertySource(value = "classpath:config1.properties", encoding = "UTF-8"),
        @PropertySource(value = "classpath:config2.yml", encoding = "UTF-8")
})
public class Main implements CommandLineRunner {
    @Resource
    AppConfig appConfig;
    @Value("${server.port}")
    private int serverPort;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        appConfig.printPort();

        System.out.println("Main->当前端口号: " + serverPort);
    }
}
