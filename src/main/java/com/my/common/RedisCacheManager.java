package com.my.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCacheManager {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String get(String key) {
        if (key == null) {
            return null;
        }
        return stringRedisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, String value) {
        try {
            stringRedisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
