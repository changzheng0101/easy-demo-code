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
