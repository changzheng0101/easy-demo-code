# openRewrite实践项目

> 可以通过抽象语法树来完成项目的完全覆盖

## 设计准则

一个好的 Recipe 运行一次和运行十次的结果应该是一样的

LST： 无损语义树，会保留注释空格等代码无关的数据，AST只保留代码结构
Recipe： 对代码操作的模板
Visitor： 通过Visitor可以对每个节点进行更改
Cursor： 可以访问父节点
ExecutionContext： 执行上下文，可以跨多个Recipe共享数据

## 常用命令

使用bash直接运行Recipe
```bash
mvn org.openrewrite.maven:rewrite-maven-plugin:6.28.0:run \
  -Drewrite.recipeArtifacts=com.weixiao:open-rewrite-demo:1.0-SNAPSHOT \
  -Drewrite.activeRecipes=jarDependencyAnalyze
```


