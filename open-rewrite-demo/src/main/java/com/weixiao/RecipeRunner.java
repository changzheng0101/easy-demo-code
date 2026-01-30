package com.weixiao;

import org.openrewrite.*;
import org.openrewrite.internal.InMemoryLargeSourceSet;
import org.openrewrite.java.JavaParser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 完成在某一个文件夹下手动运行Recipe
 * 目前这个程序无法引入相关依赖，会导致部分代码解析异常
 * @author changzheng
 * @date 2026年01月29日 20:46
 */
public class RecipeRunner {
    public static void main(String[] args) throws Exception {
        // 1. 指定要扫描的文件夹路径
        Path projectDir = Paths.get("/Users/changzheng.15/IdeaProjects/learn-project/easy-demo-code/open-rewrite-demo");
        List<Path> sourcePaths = Files.walk(projectDir)
                .filter(path -> path.toString().endsWith(".java"))
                .collect(Collectors.toList());

        // 2. 初始化 JavaParser（这里需要配置类路径，否则类型识别会失效）
        // 如果只是简单分析，可以用空配置；如果要精准分析，需要 runtimeClasspath
        JavaParser javaParser = JavaParser.fromJavaVersion()
                .logCompilationWarningsAndErrors(true)
                .build();

        // 3. 将文件夹下的 Java 文件解析为 LST
        ExecutionContext ctx = new InMemoryExecutionContext(Throwable::printStackTrace);
        List<SourceFile> cus = javaParser.parse(sourcePaths, projectDir, ctx)
                .collect(Collectors.toList());

        // 4. 实例化你的 Recipe
        Recipe recipe = new SayHelloRecipe("com.weixiao.FooBar");

        // 5. 运行 Recipe
        RecipeRun run = recipe.run(new InMemoryLargeSourceSet(cus), ctx);

        // 6. 遍历结果
        for (Result result : run.getChangeset().getAllResults()) {
            // 获取文件路径（从 Before 或 After 中取其一）
            String filePath = (result.getAfter() != null) ?
                    result.getAfter().getSourcePath().toString() :
                    result.getBefore().getSourcePath().toString();

            System.out.println("--------------------------------------------------");
            System.out.println("文件: " + filePath);
            System.out.println("--------------------------------------------------");

            // 1. 输出修改前的内容
            if (result.getBefore() != null) {
                System.out.println("<<< [修改前] <<<");
                System.out.println(result.getBefore().printAll());
            } else {
                System.out.println("<<< [新增文件] <<<");
            }

            System.out.println("\n==================================================\n");

            // 2. 输出修改后的内容
            if (result.getAfter() != null) {
                System.out.println(">>> [修改后] >>>");
                System.out.println(result.getAfter().printAll());
            } else {
                System.out.println(">>> [文件已删除] >>>");
            }
        }
    }
}
