package com.weixiao;

import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.JavaTemplate;
import org.openrewrite.java.MethodMatcher;
import org.openrewrite.java.tree.J;

import java.util.stream.Collectors;

/**
 * 重构Customer的构造函数
 *
 * @author changzheng
 * @date 2026年01月29日 17:44
 */
public class ExpandCustomerInfo extends Recipe {
    @Override
    public String getDisplayName() {
        return "Expand Customer Info";
    }

    @Override
    public String getDescription() {
        return "Expand the `CustomerInfo` class with new fields.";
    }

    @Override
    public JavaIsoVisitor<ExecutionContext> getVisitor() {
        return new JavaIsoVisitor<ExecutionContext>() {
            // Used to identify the method declaration that will be refactored
            private final MethodMatcher methodMatcher = new MethodMatcher("com.weixiao.Customer setCustomerInfo(String)");

            // Template used to insert two additional parameters into the "setCustomerInfo()" method declaration
            private final JavaTemplate addMethodParametersTemplate = JavaTemplate.builder("Date dateOfBirth, String firstName, #{}")
                    .imports("java.util.Date")
                    .contextSensitive()
                    .build();

            // Template used to add a method body to the "setCustomerInfo()" method declaration
            private final JavaTemplate addMethodBodyTemplate = JavaTemplate.builder(" ").build();

            // Template used to add statements to the method body of the "setCustomerInfo()" method
            private final JavaTemplate addStatementsTemplate = JavaTemplate.builder(
                            "this.dateOfBirth = dateOfBirth;\n" +
                                    "this.firstName = firstName;\n" +
                                    "this.lastName = lastName;\n")
                    .contextSensitive()
                    .build();


            @Override
            public J.MethodDeclaration visitMethodDeclaration(J.MethodDeclaration methodDeclaration, ExecutionContext executionContext) {
                if (!methodMatcher.matches(methodDeclaration.getMethodType())) {
                    return methodDeclaration;
                }

                // Remove the abstract modifier from the method
                methodDeclaration = methodDeclaration.withModifiers(methodDeclaration.getModifiers().stream()
                        .filter(modifier -> modifier.getType() != J.Modifier.Type.Abstract)
                        .collect(Collectors.toList()));

                // Add two parameters to the method declaration by inserting them in front of the first argument
                methodDeclaration =
                        addMethodParametersTemplate.apply(updateCursor(methodDeclaration),
                                methodDeclaration.getCoordinates().replaceParameters(),
                                methodDeclaration.getParameters().get(0));


                // Add a method body and format it
                methodDeclaration = maybeAutoFormat(
                        methodDeclaration, addMethodBodyTemplate.apply(updateCursor(methodDeclaration), methodDeclaration.getCoordinates().replaceBody()),
                        executionContext
                );

                // Safe to assert since we just added a body to the method
                assert methodDeclaration.getBody() != null;

                // Add the assignment statements to the "setCustomerInfo()" method body
                methodDeclaration = addStatementsTemplate.apply(updateCursor(methodDeclaration), methodDeclaration.getBody().getCoordinates().lastStatement());

                return methodDeclaration;
            }
        };
    }
}

