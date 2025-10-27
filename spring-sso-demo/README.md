# 单点登录
完成单点登录的示例代码
一次登录，可以在多个应用中使用，无需重复登录，登录的时候需要访问特定的鉴权服务器。

http://localhost/8081      | resource-server |
http://localhost/8082      | client-1        |
http://localhost:8083/auth | 认证服务器        |
http://localhost/8084      | client-2        |

验证教程:
访问 http://localhost:8084/ui-two/foos 会跳转到登录地址

登录账号:
1. john@test.com / 123
2. mike@other.com / pass

登录后两个都可以访问:
http://localhost:8084/ui-two/foos
http://localhost:8082/ui-one/foos

