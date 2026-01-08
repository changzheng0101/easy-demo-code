package com.weixiao;

import com.weixiao.domain.Tool;
import lombok.Data;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

/**
 * 继承AbstractFactoryBean，通过getObject获取真正的对象
 *
 * @author changzheng
 * @date 2025年10月28日 11:01
 */
@Data
@Component
public class NonSingleToolFactory extends AbstractFactoryBean<Tool> {

    private int factoryId;
    private int toolId;

    public NonSingleToolFactory() {
        this.factoryId = 2;
        this.toolId = 2;
        setSingleton(false);
    }


    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

    @Override
    protected Tool createInstance() throws Exception {
        return new Tool(toolId);
    }

}
