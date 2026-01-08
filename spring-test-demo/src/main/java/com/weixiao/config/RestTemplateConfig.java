package com.weixiao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * RestTemplate的配置类，一开始的目的是为了当ducc配置变更时，可以同时更新配置
 *
 * @author changzheng
 * @date 2026年01月07日 15:01
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 连接超时时间
     */
    private int connectTimeout = 10;

    /**
     * 读取超时时间
     */
    @Value("${restTemplate.readTimeout}")
    private int readTimeout;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .connectTimeout(Duration.ofSeconds(connectTimeout))
                .readTimeout(Duration.ofSeconds(readTimeout))
                .build();
    }
}
