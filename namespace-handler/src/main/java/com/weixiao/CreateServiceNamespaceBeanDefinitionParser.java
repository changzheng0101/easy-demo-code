package com.weixiao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import java.util.Arrays;

/**
 * @author changzheng
 * @date 2025年11月17日 10:07
 */
public class CreateServiceNamespaceBeanDefinitionParser implements BeanDefinitionParser {
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        //parsing <custns:abcd service="myservice" dao="mydao" fields="field1,field2,field3"/>
        //<custns:createservice serviceId="myservice-123" daoId="mydao-123" fields="field1,field2,field3"/>

        BeanDefinitionRegistry registry = parserContext.getRegistry();

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyDAO.class);
        builder.addPropertyValue("fields", Arrays.asList(element.getAttribute("fields").split(",")));
        String daoId = element.getAttribute("daoId");
        registry.registerBeanDefinition(daoId, builder.getBeanDefinition());


        ManagedMap<Object, Object> map = new ManagedMap<>();
        map.put("dao1", new RuntimeBeanReference(daoId));
        builder = BeanDefinitionBuilder.genericBeanDefinition(MyService.class);
        builder.addPropertyValue("serviceName", "myservice");
        builder.addPropertyReference("defaultDao", daoId);
        builder.addPropertyValue("daoRegistry", map);
        registry.registerBeanDefinition(element.getAttribute("serviceId"), builder.getBeanDefinition());

        return null;
    }
}
