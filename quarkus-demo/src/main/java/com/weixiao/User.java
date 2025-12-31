package com.weixiao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "demo_users")
public class User extends PanacheEntity {
    public String name;
    public String email;


    public static List<User> findUserDynamic(String name, String email) {
        Map<String, Object> params = new HashMap<>();
        List<String> conditions = new ArrayList<>();

        if (name != null && !name.isBlank()) {
            conditions.add("name = :name");
            params.put("name", name);
        }

        if (email != null && !email.isBlank()) {
            conditions.add("email like :email");
            params.put("email", "%" + email + "%");
        }

        // 如果没有任何条件，直接调用 listAll()
        if (conditions.isEmpty()) {
            return User.listAll();
        }

        // 将条件列表用 " AND " 连接起来，例如 "name = :name AND email like :email"
        String query = String.join(" and ", conditions);
        return User.list(query, params);
    }
}