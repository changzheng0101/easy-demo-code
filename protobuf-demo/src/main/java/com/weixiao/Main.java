package com.weixiao;

import com.google.protobuf.InvalidProtocolBufferException;
import com.weixiao.protobuf.model.UserRequest;

/**
 * @author changzheng
 * @date 2026年02月10日 11:15
 */
public class Main {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        // 1. 序列化（将对象转为字节流）
        UserRequest user = UserRequest.newBuilder()
                .setId(1001)
                .setName("Gemini")
                .setEmail("gemini@example.com")
                .build();

        byte[] bytes = user.toByteArray(); // 这一步就是编码，可以发给 C++, Go, 或者存入数据库

        // 2. 反序列化（将字节流转回对象）
        UserRequest decodedUser = UserRequest.parseFrom(bytes);
        System.out.println("ID: " + decodedUser.getId());
    }
}
