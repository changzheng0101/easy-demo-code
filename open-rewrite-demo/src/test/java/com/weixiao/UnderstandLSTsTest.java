package com.weixiao;

import org.junit.jupiter.api.Test;
import org.openrewrite.ExecutionContext;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.TreeVisitingPrinter;
import org.openrewrite.java.tree.Expression;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;
import static org.openrewrite.test.RewriteTest.toRecipe;

/**
 * @author changzheng
 * @date 2026年01月30日 18:06
 */
public class UnderstandLSTsTest implements RewriteTest {
    @Test
    void printExpressions() {
        rewriteRun(
                spec -> spec.recipe(toRecipe(() -> new JavaIsoVisitor<>() {
                    @Override
                    public Expression visitExpression(Expression expression, ExecutionContext executionContext) {
                        System.out.println(TreeVisitingPrinter.printTree(expression));
                        return super.visitExpression(expression, executionContext);
                    }
                })),
                java(
                        """
                                package org.openrewrite;
                                
                                import java.util.ArrayList;
                                import java.util.List;
                                import java.util.stream.Collectors;
                                
                                @AnAnnotation
                                public class A {
                                
                                    List<Integer> a = new ArrayList<>();
                                
                                    int foo() {
                                        int a = 1 + 2, b = 3, c;
                                        this.a = this.a.stream()
                                                .map(it -> it + 1)
                                                .collect(Collectors.toList());
                                        return a;
                                    }
                                }
                                
                                @interface AnAnnotation {}
                                """)
        );
    }
}
