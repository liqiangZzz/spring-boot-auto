package com.lq.service;

/**
 * @ClassName CacheService
 * @Description 缓存服务
 * @Author liqiang
 * @Date 2025/11/17 14:34
 */
public class CacheService {

    public void cacheData(String key, Object value) {
        System.out.println("Caching data: " + key + " = " + value);
    }
}
