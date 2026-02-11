package com.weixiao;

import java.lang.instrument.Instrumentation;

/**
 * 统一入口：通过 MANIFEST.MF 的 Premain-Class 指定此类，
 * 在 premain 中依次调用所有子 Agent，使多个 Agent 同时生效。
 */
public class CompositeAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("========== CompositeAgent 启动，将依次执行以下 Agent ==========");

        SimpleAgent.premain(agentArgs, inst);
        TimingAgent.premain(agentArgs, inst);
        LoggingAgent.premain(agentArgs, inst);
        FilterAgent.premain(agentArgs, inst);

        System.out.println("========== 所有 Agent 已注册 ==========");
    }
}
