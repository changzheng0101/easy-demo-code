package com.weixiao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author changzheng
 * @date 2025年11月17日 10:03
 */
public class NamespaceMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MyService myService = context.getBean("myservice-123", MyService.class);
        System.out.println(myService);

        MyService myService2 = context.getBean("myService", MyService.class);
        System.out.println(myService2);
    }
}
