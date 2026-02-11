# java agent 示例代码
> 简单实现了java agent，可以在类创建前修改模板

配套的示例代码可以使用 java-demo 中的代码，运行命令如下
```bash
java -javaagent:path-to/target/java-agent-demo-1.0-SNAPSHOT.jar=HelloAgent -jar target/java-demo-1.0-SNAPSHOT.jar
```