package com.weixiao;

import com.weixiao.base.PropertyOverrideContextInitializer;
import com.weixiao.service.HelloService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(
        initializers = PropertyOverrideContextInitializer.class
)
class SpringTestDemoTest {
    @Resource
    private HelloService helloService;
    @Resource
    private PropertySourceResolver propertySourceResolver;

    @Test
    public void testRunSuccess() {
        assertEquals("hello", helloService.sayHello());
    }

    /**
     * 测试路径下的配置文件会替换main路径下文件的配置值
     */
    @Test
    public void testPropertiesVal() {
        // PropertyOverrideContextInitializer 不启用时这个可以跑通
        // assertEquals("test-firstVal", propertySourceResolver.getFirstProperty());
        assertEquals("test-secondVal", propertySourceResolver.getSecondProperty());
    }

    /**
     * 测试路径下的配置文件会替换main路径下文件的配置值
     */
    @Test
    public void testPropertiesValInjectWithCode() {
        assertEquals("contextClass", propertySourceResolver.getFirstProperty());
        assertEquals("test-secondVal", propertySourceResolver.getSecondProperty());
    }
}