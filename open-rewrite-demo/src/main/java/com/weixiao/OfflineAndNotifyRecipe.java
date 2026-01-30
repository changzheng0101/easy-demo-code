package com.weixiao;

import org.jetbrains.annotations.NotNull;
import org.openrewrite.ExecutionContext;
import org.openrewrite.ScanningRecipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.JavaTemplate;
import org.openrewrite.java.JavaVisitor;
import org.openrewrite.java.tree.J;

/**
 * 完成在一个文件中修改代码，之后再另一个文件中添加代码
 * 如果oldService中有stop方法，就移除OldService的stop方法，之后GlobalLog中添加一个静态变量。
 *
 * @author changzheng
 * @date 2026年01月30日 16:28
 */
public class OfflineAndNotifyRecipe extends ScanningRecipe<OfflineAndNotifyRecipe.Accumulator> {

    // 1. 定义累加器：用于在文件间传递状态
    public static class Accumulator {
        boolean methodFound = false;
    }

    @Override
    public Accumulator getInitialValue(ExecutionContext ctx) {
        return new Accumulator();
    }

    @Override
    public String getDisplayName() {
        return "跨类修改示例";
    }

    @Override
    public String getDescription() {
        return "在 A 类执行修改，并在 B 类同步添加代码。";
    }

    // 2. 第一阶段：扫描所有文件
    @Override
    public TreeVisitor<?, ExecutionContext> getScanner(Accumulator acc) {
        return new JavaVisitor<>() {
            @Override
            public J visitMethodDeclaration(J.MethodDeclaration method, ExecutionContext executionContext) {
                if (method.getSimpleName().equals("stop")) {
                    acc.methodFound = true;
                }
                return super.visitMethodDeclaration(method, executionContext);
            }
        };
    }

    // 3. 第二阶段：根据扫描结果进行修改
    @Override
    public @NotNull TreeVisitor<?, @NotNull ExecutionContext> getVisitor(Accumulator acc) {
        return new JavaVisitor<>() {
            @Override
            public J visitCompilationUnit(J.CompilationUnit cu, ExecutionContext ctx) {
                String className = cu.getClasses().get(0).getSimpleName();
                // 逻辑 B：如果是 GlobalLog，且改属性不存在，添加一行属性
                if (acc.methodFound && className.equals("GlobalLog")) {
                    J.ClassDeclaration clazz = cu.getClasses().get(0);
                    boolean alreadyExists = clazz.getBody().getStatements().stream()
                            .filter(s -> s instanceof J.VariableDeclarations)
                            .map(s -> (J.VariableDeclarations) s)
                            .anyMatch(v -> v.getVariables().stream()
                                    .anyMatch(var -> "STATUS".equals(var.getSimpleName())));
                    if (!alreadyExists) {
                        return JavaTemplate.builder("private static final String STATUS = \"STOPPED\";")
                                .contextSensitive()
                                .build()
                                .apply(getCursor(), cu.getClasses().get(0).getBody().getCoordinates().lastStatement());
                    }
                }

                return super.visitCompilationUnit(cu, ctx);
            }

            @Override
            public J visitMethodDeclaration(J.MethodDeclaration method, ExecutionContext executionContext) {
                if (acc.methodFound && method.getSimpleName().equals("stop")) {
                    J.ClassDeclaration enclosingClass = getCursor().firstEnclosing(J.ClassDeclaration.class);
                    if (enclosingClass != null && "OldService".equals(enclosingClass.getSimpleName())) {
                        // 返回 null 表示从 LST 中移除该方法定义
                        return null;
                    }
                }

                return super.visitMethodDeclaration(method, executionContext);
            }
        };
    }
}
