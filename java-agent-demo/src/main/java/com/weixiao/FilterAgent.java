package com.weixiao;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * 仅监控应用自身类（过滤掉 JDK/第三方）的 Agent
 */
public class FilterAgent {
    private static final String APP_PACKAGE = "com/weixiao";

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("[FilterAgent] 已启动，仅监控 " + APP_PACKAGE.replace("/", ".") + " 包下的类");

        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className,
                                    Class<?> classBeingRedefined,
                                    ProtectionDomain protectionDomain,
                                    byte[] classfileBuffer) {
                if (className != null && className.startsWith(APP_PACKAGE)) {
                    System.out.println("[FilterAgent] 应用类加载: " + className.replace("/", "."));
                }
                return null;
            }
        });
    }
}
