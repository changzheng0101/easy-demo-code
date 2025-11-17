package com.weixiao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Arrays;

/**
 * @author changzheng
 * @date 2025年11月17日 10:07
 */
public class CreateServiceNamespaceBeanDefinitionParser implements BeanDefinitionParser {
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionRegistry registry = parserContext.getRegistry();
        String serviceId = element.getAttribute("serviceId");
        String daoId = element.getAttribute("daoId");
        String fields = element.getAttribute("fields");

        // Create and register the default DAO
        BeanDefinitionBuilder daoBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyDAO.class);
        daoBuilder.addPropertyValue("fields", Arrays.asList(fields.split(",")));
        registry.registerBeanDefinition(daoId, daoBuilder.getBeanDefinition());

        // Create the service builder
        BeanDefinitionBuilder serviceBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyService.class);
        serviceBuilder.addPropertyValue("serviceName", serviceId);
        serviceBuilder.addPropertyReference("defaultDao", daoId);

        // Create and populate the daoRegistry
        ManagedMap<Object, Object> daoRegistry = new ManagedMap<>();
        
        // Add the default DAO to the registry
        daoRegistry.put("default", new RuntimeBeanReference(daoId));
        
        // Process nested <dao> elements
        NodeList daoNodes = element.getChildNodes();
        for (int i = 0; i < daoNodes.getLength(); i++) {
            Node node = daoNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE && "dao".equals(node.getLocalName())) {
                Element daoElement = (Element) node;
                String key = daoElement.getAttribute("key");
                String ref = daoElement.getAttribute("ref");
                if (key != null && !key.isEmpty() && ref != null && !ref.isEmpty()) {
                    daoRegistry.put(key, new RuntimeBeanReference(ref));
                }
            }
        }

        // Set the daoRegistry property
        serviceBuilder.addPropertyValue("daoRegistry", daoRegistry);
        
        // Register the service bean
        registry.registerBeanDefinition(serviceId, serviceBuilder.getBeanDefinition());

        return null;
    }
}
