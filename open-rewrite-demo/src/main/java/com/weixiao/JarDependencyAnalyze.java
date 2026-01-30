package com.weixiao;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.openrewrite.ExecutionContext;
import org.openrewrite.NlsRewrite;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.JavaTemplate;
import org.openrewrite.java.tree.J;
import org.openrewrite.java.tree.TypeUtils;

import java.util.Comparator;
import java.util.logging.Logger;

/**
 * 分析jar包对应的所有依赖项
 *
 * @author changzheng
 * @date 2026年01月29日 20:29
 */
@Value
@EqualsAndHashCode(callSuper = false)
public class JarDependencyAnalyze extends Recipe {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    String displayName = "dependency analyze";
    String description = "analyze dependency for a jar file";

    @Override
    public TreeVisitor<?, ExecutionContext> getVisitor() {
        // JavaIsoVisitor 不改变返回Node的类型
        // JavaVisitor 可以改变返回的类型，比较灵活
        // getVisitor() should always return a new instance of the visitor to avoid any state leaking between cycles
        return new JavaIsoVisitor<>() {
            @Override
            public J.ClassDeclaration visitClassDeclaration(J.ClassDeclaration classDecl, ExecutionContext ctx) {
                logger.info(classDecl.getType().toString());
                return classDecl;
            }
        };
    }
}
