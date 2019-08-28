package com.logesta.redissvc.services;

import com.logesta.redissvc.models.User;

public interface RedisService {
    public abstract void saveUser(User user);
    public abstract User getUser(String id);
    public abstract void saveJson(String key,String json);
    public abstract String getJson(String key);
}