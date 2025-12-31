
创建用户
```bash
# 创建用户
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Tom", "email":"tom@example.com"}'
  
# 查看所有用户
curl http://localhost:8080/users
```