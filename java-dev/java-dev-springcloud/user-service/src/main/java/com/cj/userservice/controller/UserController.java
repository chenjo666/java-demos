package com.cj.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Map<Long, Object> users = new HashMap<>();
    {
        Map<String, Object> user1 = new HashMap<>();
        user1.put("name", "张三");
        user1.put("age", 19);
        user1.put("sex", "男");
        Map<String, Object> user2 = new HashMap<>();
        user2.put("name", "李四");
        user2.put("age", 20);
        user2.put("sex", "男");
        users.put(1L, user1);
        users.put(2L, user2);
    }
    @GetMapping("/v1/{userId}")
    public Object getUser(@PathVariable("userId") Long userId) {
        return users.getOrDefault(userId, new HashMap<>());
    }
}
