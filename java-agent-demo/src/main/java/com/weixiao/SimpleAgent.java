package com.weixiao;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * java agent 可以在创建类的时候修改代码
 * 在类加载阶段对模板进行初始化
 *
 * @author changzheng
 * @date 2026年02月11日 10:51
 */
public class SimpleAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Java Agent 已启动！参数: " + agentArgs);

        // 只监控 com.weixiao 包下的类
        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className,
                                    Class<?> classBeingRedefined,
                                    ProtectionDomain protectionDomain,
                                    byte[] classfileBuffer) {
                if (className != null && className.startsWith("com/weixiao")) {
                    System.out.println("正在加载类: " + className.replace("/", "."));
                }
                return null;
            }
        });
    }
}
