package com.lq.controller;

import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName RedisController
 * @Description
 * @Author liqiang
 * @Date 2025/11/7 17:12
 */
@RestController
public class RedisController {

    @Resource
    private RedissonClient redissonClient;

    @GetMapping("/query")
    public String query(){
        return "key的个数="+redissonClient.getKeys().count()+"";
    }
}
