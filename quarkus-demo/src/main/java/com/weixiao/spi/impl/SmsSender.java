package com.weixiao.spi.impl;

import com.weixiao.spi.MessageSender;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * @author changzheng
 * @date 2025年12月31日 16:39
 */
@ApplicationScoped
public class SmsSender implements MessageSender {
    @Override
    public String getName() { return "sms"; }

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
