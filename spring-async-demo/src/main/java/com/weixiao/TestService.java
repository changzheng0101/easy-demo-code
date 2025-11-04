package com.weixiao;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author changzheng
 * @date 2025年11月04日 11:12
 */
@Service
@Slf4j
public class TestService {

    @Async("asyncThreadPoolTaskExecutor")
    public Future<String> asyncMethodWithReturnVal() {
        sleep();
        log.info("指定线程池+返回值--异步方法内部线程名称：{}", Thread.currentThread().getName());
        return new AsyncResult<>("hello async");
    }

    @Async(value = "asyncThreadPoolTaskExecutor")
    public void myAsyncMethod() {
        sleep();
        log.info("指定线程池--异步方法内部线程名称：{}", Thread.currentThread().getName());
    }

    @Async
    public void asyncMethod() {
        sleep();
        log.info("异步方法内部线程名称：{}", Thread.currentThread().getName());
    }

    public void syncMethod() {
        sleep();
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
