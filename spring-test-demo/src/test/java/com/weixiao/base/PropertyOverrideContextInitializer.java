package com.weixiao.base;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;

/**
 * @author changzheng
 * @date 2025年10月24日 16:12
 */
public class PropertyOverrideContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    static final String PROPERTY_FIRST_VALUE = "contextClass";

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        // 这个将重写 环境中的值
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                configurableApplicationContext, "example.firstProperty=" + PROPERTY_FIRST_VALUE);

//        TestPropertySourceUtils.addPropertiesFilesToEnvironment(
//                configurableApplicationContext, "context-override-application.properties");
    }
}
