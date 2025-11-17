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
        String defaultDaoId = element.getAttribute("daoId");
        String defaultFields = element.getAttribute("fields");

        // Create and register the default DAO
        BeanDefinitionBuilder defaultDaoBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyDAO.class);
        defaultDaoBuilder.addPropertyValue("fields", Arrays.asList(defaultFields.split(",")));
        registry.registerBeanDefinition(defaultDaoId, defaultDaoBuilder.getBeanDefinition());

        // Create the service builder
        BeanDefinitionBuilder serviceBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyService.class);
        serviceBuilder.addPropertyValue("serviceName", serviceId);
        serviceBuilder.addPropertyReference("defaultDao", defaultDaoId);

        // Create and populate the daoRegistry
        ManagedMap<Object, Object> daoRegistry = new ManagedMap<>();
        
        // Add the default DAO to the registry
        daoRegistry.put("default", new RuntimeBeanReference(defaultDaoId));
        
        // Process nested <dao> elements
        NodeList daoNodes = element.getChildNodes();
        for (int i = 0; i < daoNodes.getLength(); i++) {
            Node node = daoNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE && "dao".equals(node.getLocalName())) {
                Element daoElement = (Element) node;
                String key = daoElement.getAttribute("key");
                String fields = daoElement.getAttribute("fields");
                
                if (!key.isEmpty() && !fields.isEmpty()) {
                    // Create a new DAO for each dao element
                    String daoBeanId = serviceId + "_" + key + "Dao";
                    BeanDefinitionBuilder daoBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyDAO.class);
                    daoBuilder.addPropertyValue("fields", Arrays.asList(fields.split(",")));
                    registry.registerBeanDefinition(daoBeanId, daoBuilder.getBeanDefinition());
                    
                    // Add to registry with the specified key
                    daoRegistry.put(key, new RuntimeBeanReference(daoBeanId));
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
