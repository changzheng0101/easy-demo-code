package com.weixiao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author changzheng
 * @date 2025年10月24日 16:04
 */
@Component
public class PropertySourceResolver {

    @Value("${example.firstProperty}")
    private String firstProperty;
    @Value("${example.secondProperty}")
    private String secondProperty;

    public String getFirstProperty() {
        return firstProperty;
    }

    public String getSecondProperty() {
        return secondProperty;
    }
}
