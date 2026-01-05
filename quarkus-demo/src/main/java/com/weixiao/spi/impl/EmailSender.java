package com.weixiao.spi.impl;

import com.weixiao.spi.MessageSender;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * @author changzheng
 * @date 2025年12月31日 16:38
 */
@ApplicationScoped
public class EmailSender implements MessageSender {
    @Override
    public String getName() { return "email"; }

    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}