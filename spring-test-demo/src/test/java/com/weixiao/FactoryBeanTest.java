package com.weixiao;

import com.weixiao.domain.Tool;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author changzheng
 * @date 2025年10月28日 11:01
 */
@SpringBootTest
public class FactoryBeanTest {

    @Autowired
    SingleToolFactory singleToolFactory;

    @Autowired
    NonSingleToolFactory nonSingleToolFactory;

    @Test
    public void testSingleToolFactory() throws Exception {
        Tool tool1 = singleToolFactory.getObject();
        Tool tool2 = singleToolFactory.getObject();
        assertThat(tool1.getId(), equalTo(1));
        assertTrue(tool1 == tool2);
    }

    @Test
    public void testNonSingleToolFactory() throws Exception {
        Tool tool3 = nonSingleToolFactory.getObject();
        Tool tool4 = nonSingleToolFactory.getObject();
        assertThat(tool3.getId(), equalTo(2));
        assertThat(tool4.getId(), equalTo(2));
        assertTrue(tool3 != tool4);
    }
}
