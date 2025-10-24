package com.example.jwtdemo.domain;

import java.util.List;

/**
 * @author changzheng
 * @date 2025年10月24日 14:12
 * <p>
 * 事件的详细信息，包括基本信息，权限、角色等
 */
public class AppUserinfo {
    private Long id;
    private String name;
    private String username;
    private String password;
    private List<Role> roles;
    private List<String> permissions;
}
