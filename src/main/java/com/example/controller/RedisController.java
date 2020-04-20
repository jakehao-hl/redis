package com.example.controller;

import com.example.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    private String hello() {
        User user = new User(1, "java的架构师技术栈", "man");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("fdd2", user);
        boolean exists = redisTemplate.hasKey("fdd2");
        System.out.println("redis是否存在相应的key" + exists);
        User getUser = (User) redisTemplate.opsForValue().get("fdd2");
        System.out.println("从redis数据库获取的user:" + getUser.toString());
        return "SUCCESS";
    }
}

