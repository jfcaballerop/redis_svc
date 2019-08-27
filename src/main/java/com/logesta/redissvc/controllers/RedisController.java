package com.logesta.redissvc.controllers;

import com.logesta.redissvc.models.User;
import com.logesta.redissvc.services.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    RedisService redis;

    @PostMapping("/set")
    public void redisSet(@RequestBody User user) {
        redis.saveUser(user);

        // System.out.println("redisSet POST");
    }

    @GetMapping("/get/{sessionid}")
    public User redisGet(@PathVariable("sessionid") String sessionid) {

        return redis.getUser(sessionid);
    }

}