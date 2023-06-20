package org.sijinghua.seckill.application.service;

import org.sijinghua.seckill.domain.model.SeckillUser;

/**
 * @Date: 2023/5/28
 * @Author: Jonah Si
 * @Description: 用户服务接口
 */
public interface SeckillUserService {
    /**
     * 根据用户名获取用户信息
     */
    SeckillUser getSeckillUserByUserName(String userName);

    /**
     * 用户登录
     */
    String login(String userName, String password);
}
