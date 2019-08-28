package com.logesta.redissvc.services;

import com.logesta.redissvc.models.User;
import com.logesta.redissvc.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private StringRedisTemplate strRedisTemplate;

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }
    @Override
    public User getUser(String id) {
        return userRepo.findById(id).get();
    }
    
    @Override
    public void saveJson(String key,String json){
        ValueOperations values = strRedisTemplate.opsForValue();
            values.set(key, json);
    }

    @Override
    public String getJson(String key){
        ValueOperations values = strRedisTemplate.opsForValue();
        return values.get(key).toString();
    }
}