package com.logesta.redissvc.controllers;

import com.logesta.redissvc.models.User;
import com.logesta.redissvc.services.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping("/setUser")
    public void redisSet(@RequestBody User user) {
        redis.saveUser(user);
    }

    @GetMapping("/getUser/{sessionid}")
    public User redisGet(@PathVariable("sessionid") String sessionid) {
        return redis.getUser(sessionid);
    }

    @PostMapping("/setJson/{sessionid}")
    public void redisSetJson(@PathVariable("sessionid") String key, @RequestBody String jsonObject) {
        redis.saveJson(key, jsonObject);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getJson/{sessionid}")
    public String redisGetJson(@PathVariable("sessionid") String key) {

        return redis.getJson(key);
    }

}