package com.weixiao;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * 统计类加载（经过 Agent 转换）耗时的 Agent
 */
public class TimingAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("[TimingAgent] 已启动，只统计 com.weixiao 包下类的转换耗时");

        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className,
                                    Class<?> classBeingRedefined,
                                    ProtectionDomain protectionDomain,
                                    byte[] classfileBuffer) {
                if (className == null || !className.startsWith("com/weixiao")) {
                    return null;
                }
                long start = System.nanoTime();
                try {
                    return null;
                } finally {
                    long nanos = System.nanoTime() - start;
                    if (nanos > 50_000) {
                        System.out.println("[TimingAgent] " + className.replace("/", ".") + " 转换耗时: " + (nanos / 1000) + " μs");
                    }
                }
            }
        });
    }
}
