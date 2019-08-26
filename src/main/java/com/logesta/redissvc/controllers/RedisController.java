package com.logesta.redissvc.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {


    @PostMapping("/set")
    public void redisSet(){
        System.out.println("redisSet POST");
    }
    
    @PostMapping("/get")
    public String redisGet(){
        return "redisGet POST";
    }

}