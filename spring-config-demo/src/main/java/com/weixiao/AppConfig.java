package com.weixiao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author changzheng
 * @date 2025年10月22日 14:36
 */
@Component
public class AppConfig {
    // 因为配置了是static类型的，所以会获取不到数据
    @Value("${server.port}")
    private static String port1;
    @Autowired
    private Environment environment;
    @Value("${listOfValues}")
    private String[] listOfValues;
    @Value("${selfDefine.demo}")
    private String selfDefineVal;
    @Value("${notExist:hello}")
    private String notExist;
    @Value("${a}")
    private String a;

    public void printPort() {
        // 可以直接访问application.properties中的属性
        String port = environment.getProperty("server.port");
        System.out.println("当前端口号: " + port);
        // hello.properties中的属性无法访问 -> 需要添加注解@PropertySources才可以访问
        String test = environment.getProperty("selfDefine.demo");
        System.out.println("测试属性: " + test);
        // application.properties的自定义属性也可以直接访问
        String selfDefine = environment.getProperty("cc.cc");
        System.out.println("测试属性: " + selfDefine);


        for (String value : listOfValues) {
            System.out.println(value);
        }

        System.out.println(selfDefineVal);

        System.out.println("当前端口号: " + port1);

        System.out.println(notExist);

        System.out.println("a --> " + a);
    }
}
