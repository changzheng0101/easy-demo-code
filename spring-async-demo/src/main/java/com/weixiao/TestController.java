package com.weixiao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author changzheng
 * @date 2025年11月04日 11:12
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("async")
    public void testAsync() {
        long start = System.currentTimeMillis();
        log.info("异步方法开始");
        testService.asyncMethod();
        log.info("异步方法结束");
        long end = System.currentTimeMillis();
        log.info("总耗时：{} ms", end - start);
    }

    @RequestMapping("sync")
    public void testSync() {
        long start = System.currentTimeMillis();
        log.info("同步方法开始");
        testService.syncMethod();
        log.info("同步方法结束");
        long end = System.currentTimeMillis();
        log.info("总耗时：{} ms", end - start);
    }

    @RequestMapping("syncWithReturnVal")
    public String  testSyncWithReturnVal() throws Exception {
        long start = System.currentTimeMillis();
        log.info("异步方法开始");
        Future<String> stringFuture = testService.asyncMethodWithReturnVal();
        String result = stringFuture.get();
        log.info("异步方法返回值：{}", result);
        log.info("异步方法结束");

        long end = System.currentTimeMillis();
        log.info("总耗时：{} ms", end - start);
        return stringFuture.get();
    }
}
