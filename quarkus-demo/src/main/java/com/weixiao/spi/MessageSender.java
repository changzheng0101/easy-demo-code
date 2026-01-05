package com.weixiao.spi;

/**
 * @author changzheng
 * @date 2025年12月31日 16:38
 */
public interface MessageSender {
    String getName();

    void send(String message);
}