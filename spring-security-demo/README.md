# spring security demo

需要先在数据库中创建userservice数据库

创建用户curl
```bash
curl --request POST \
  --url http://127.0.0.1:8080/api/user/save \
  --header 'Accept: */*' \
  --header 'Accept-Encoding: gzip, deflate, br' \
  --header 'Connection: keep-alive' \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: PostmanRuntime-ApipostRuntime/1.1.0' \
  --data '{
    "username":"hello",
    "password":"world"
}'
```

登录curl
```bash
curl --request POST \
--url 'http://127.0.0.1:8080/api/login?username=john&password=123456' \
--header 'Accept: */*' \
--header 'Accept-Encoding: gzip, deflate, br' \
--header 'Connection: keep-alive' \
--header 'User-Agent: PostmanRuntime-ApipostRuntime/1.1.0'
```


HandlerFilter 和 Filter 都可以在请求过程中进行一些操作，一次请求中位于的位置如下：
```
┌────────────────────────────┐
│        客户端请求          │
└─────────────┬──────────────┘
              │
┌─────────────▼──────────────┐
│        Filter链            │
│ (如 Spring Security Filter)│
└─────────────┬──────────────┘
              │
┌─────────────▼──────────────┐
│    DispatcherServlet       │
└─────────────┬──────────────┘
              │
┌─────────────▼──────────────┐
│   HandlerInterceptor       │
│   (preHandle)              │
└─────────────┬──────────────┘
              │
┌─────────────▼──────────────┐
│      Controller            │
└─────────────┬──────────────┘
              │
┌─────────────▼──────────────┐
│   HandlerInterceptor       │
│ (postHandle/afterCompletion)│
└─────────────┬──────────────┘
              │
┌─────────────▼──────────────┐
│    DispatcherServlet       │
└─────────────┬──────────────┘
              │
┌─────────────▼──────────────┐
│        Filter链            │
└─────────────┬──────────────┘
              │
┌─────────────▼──────────────┐
│        客户端响应          │
└────────────────────────────┘
```