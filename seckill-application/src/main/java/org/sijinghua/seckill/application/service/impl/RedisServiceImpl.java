package org.sijinghua.seckill.application.service.impl;

import org.sijinghua.seckill.application.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Date: 2023/6/5
 * @Author: Jonah Si
 * @Description: Redis服务实现类
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
