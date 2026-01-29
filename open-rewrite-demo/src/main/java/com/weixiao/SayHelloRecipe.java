package com.weixiao;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.openrewrite.ExecutionContext;
import org.openrewrite.Option;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.JavaTemplate;
import org.openrewrite.java.tree.J;
import org.openrewrite.java.tree.TypeUtils;

import java.util.Comparator;

/**
 * 如果类中不存在 hello方法，就往里面添加hello方法
 *
 * @author changzheng
 * @date 2026年01月29日 16:58
 */
@Value
@EqualsAndHashCode(callSuper = false)
public class SayHelloRecipe extends Recipe {
    @Option(displayName = "fully Qualified Class Name",
            description = "A fully qualified class name indicating which class to add a hello() method to.",
            example = "com.yourorg.FooBar")
    String fullyQualifiedClassName;

    // With lombok you can use Strings directly instead of overriding the methods
    String displayName = "Say 'Hello'";
    String description = "Adds a `hello` method to the specified class.";

    @Override
    public TreeVisitor<?, ExecutionContext> getVisitor() {
        // JavaIsoVisitor 不改变返回Node的类型
        // JavaVisitor 可以改变返回的类型，比较灵活
        // getVisitor() should always return a new instance of the visitor to avoid any state leaking between cycles
        return new JavaIsoVisitor<>() {
            @Override
            public J.ClassDeclaration visitClassDeclaration(J.ClassDeclaration classDecl, ExecutionContext ctx) {
                // 1、Filter out classes that don't match the fully qualified name
                if (!TypeUtils.isOfClassType(classDecl.getType(), fullyQualifiedClassName)) {
                    return classDecl;
                }

                // 2、 Filter out classes that already have a `hello()` method
                boolean helloMethodExists = classDecl.getBody().getStatements().stream()
                        .filter(J.MethodDeclaration.class::isInstance)
                        .map(J.MethodDeclaration.class::cast)
                        .map(J.MethodDeclaration::getSimpleName)
                        .anyMatch("hello"::equals);
                if (helloMethodExists) {
                    return classDecl;
                }

                // 3、 Add a `hello()` method to classes that need it
                return JavaTemplate.apply("public String hello() { return \"Hello from #{}!\"; }",
                        updateCursor(classDecl),
                        classDecl.getBody().getCoordinates().addMethodDeclaration(Comparator.comparing(J.MethodDeclaration::getSimpleName)),
                        fullyQualifiedClassName);
            }
        };
    }
}
