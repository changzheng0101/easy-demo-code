package com.weixiao;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 统计已加载类数量的 Agent
 */
public class LoggingAgent {
    private static final AtomicLong classCount = new AtomicLong(0);

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("[LoggingAgent] 已启动，只统计 com.weixiao 包下加载的类数量");

        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className,
                                    Class<?> classBeingRedefined,
                                    ProtectionDomain protectionDomain,
                                    byte[] classfileBuffer) {
                if (className != null && className.startsWith("com/weixiao")) {
                    long n = classCount.incrementAndGet();
                    System.out.println("[LoggingAgent] 已加载类 #" + n + ": " + className.replace("/", "."));
                }
                return null;
            }
        });
    }
}
