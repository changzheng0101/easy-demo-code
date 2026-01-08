package com.weixiao;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.type.PrimitiveType;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JavaFileModifier {
    public static void main(String[] args) {
        // 定义输入和输出路径
        String inputPath = "java-parser-demo/src/main/resources/Source.java";
        String outputPath = "java-parser-demo/src/main/resources/ModifiedSource.java";

        try {
            // 1. 从文件中读取并解析代码
            File inputFile = new File(inputPath);
            CompilationUnit cu = StaticJavaParser.parse(inputFile);

            // 2. 找到目标方法（例如找到第一个方法，或者按名称查找）
            cu.findAll(MethodDeclaration.class).stream()
                    .findFirst() // 取第一个方法作为演示
                    .ifPresent(method -> {
                        // 3. 获取方法体
                        BlockStmt body = method.getBody().orElseGet(() -> {
                            BlockStmt newBody = new BlockStmt();
                            method.setBody(newBody);
                            return newBody;
                        });

                        // 4. 构建要插入的变量: int extraCounter = 2026;
                        VariableDeclarator declarator = new VariableDeclarator(
                                PrimitiveType.intType(),
                                "extraCounter",
                                StaticJavaParser.parseExpression("2026")
                        );
                        VariableDeclarationExpr varExpr = new VariableDeclarationExpr(declarator);

                        // 5. 在方法体的最开头插入
                        body.addStatement(0, varExpr);

                        System.out.println("已在方法 [" + method.getNameAsString() + "] 中插入变量。");
                    });

            // 6. 将修改后的 AST 树写入新文件
            // cu.toString() 会自动根据 AST 结构生成格式化后的代码字符串
            Files.write(Paths.get(outputPath), cu.toString().getBytes(StandardCharsets.UTF_8));

            System.out.println("修改成功！新文件已生成至: " + outputPath);
        } catch (IOException e) {
            System.err.println("文件操作失败: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("代码解析错误: " + e.getMessage());
        }
    }
}
