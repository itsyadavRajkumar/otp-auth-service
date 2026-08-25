package com.raj.otpauth.controller;

import com.raj.otpauth.service.RedisTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    private final RedisTestService redisTestService;

    public RedisTestController(RedisTestService redisTestService) {
        this.redisTestService = redisTestService;
    }

    @GetMapping("/redis/save")
    public String saveData() {
        redisTestService.saveData();
        return "Data saved in Redis";
    }

    @GetMapping("/redis/get")
    public String getData() {
        return redisTestService.getData();
    }
}