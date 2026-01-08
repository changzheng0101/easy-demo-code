package com.weixiao;

import com.weixiao.domain.Tool;
import lombok.Data;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

/**
 * 继承AbstractFactoryBean，通过getObject获取真正的对象
 *
 * @author changzheng
 * @date 2025年10月28日 10:59
 */
@Data
@Component
public class SingleToolFactory extends AbstractFactoryBean<Tool> {

    private int factoryId;
    private int toolId;

    public SingleToolFactory() {
        this.factoryId = 1;
        this.toolId = 1;
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
