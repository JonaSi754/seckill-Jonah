package org.sijinghua.seckill.application.service;

/**
 * @Date: 2023/6/5
 * @Author: Jonah Si
 * @Description: Redis服务
 */
public interface RedisService {
    /**
     * 设置缓存
     */
    void set(String key, Object value);
}
