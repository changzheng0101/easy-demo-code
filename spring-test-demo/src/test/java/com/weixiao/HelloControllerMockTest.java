package com.weixiao;

import com.weixiao.controller.HelloController;
import com.weixiao.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author changzheng
 * @date 2025年10月24日 16:28
 *  * 使用mock完成测试，当依赖起不来，或者只想测试Controller的时候
 *  * 比较有用
 */
@WebMvcTest(HelloController.class)
class HelloControllerMockTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private HelloService helloService;

    @Test
    void testSayHello() throws Exception {
        when(helloService.sayHello()).thenReturn("Hello, World!");

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }
}