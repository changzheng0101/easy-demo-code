package com.weixiao;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author changzheng
 * @date 2025年11月17日 10:06
 */
public class CustomNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("createservice", new CreateServiceNamespaceBeanDefinitionParser());
    }

}
