package com.raj.otpauth.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisTestService {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisTestService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveData() {

        String key = "test:data";
        String value = "Hello Redis";

        redisTemplate.opsForValue().set(
                key,
                value,
                Duration.ofMinutes(10)
        );
    }

    public String getData() {

        return redisTemplate.opsForValue()
                .get("test:data");
    }
}