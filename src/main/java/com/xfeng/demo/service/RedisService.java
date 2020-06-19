package com.xfeng.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author xuefeng.wang
 * @date 2020-06-03
 */
@Service
@RequiredArgsConstructor
public class RedisService {

    private final String REDIS_KEY = "test:";

    private final RedisTemplate<Object, Object> redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(REDIS_KEY + key, value, 2, TimeUnit.MINUTES);
    }

    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(REDIS_KEY + key);
    }

    public Boolean delete(String key) {
        return redisTemplate.delete(REDIS_KEY + key);
    }


}
