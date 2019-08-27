package com.logesta.redissvc.services;

import com.logesta.redissvc.models.User;
import com.logesta.redissvc.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }
    @Override
    public User getUser(String id) {
        return userRepo.findById(id).get();
    }

}