package org.sijinghua.seckill.application.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.sijinghua.seckill.application.service.RedisService;
import org.sijinghua.seckill.application.service.SeckillUserService;
import org.sijinghua.seckill.domain.code.HttpCode;
import org.sijinghua.seckill.domain.constants.SeckillConstants;
import org.sijinghua.seckill.domain.exception.SeckillException;
import org.sijinghua.seckill.domain.model.SeckillUser;
import org.sijinghua.seckill.domain.repository.SeckillUserRepository;
import org.sijinghua.seckill.infrastructure.shiro.utils.CommonsUtils;
import org.sijinghua.seckill.infrastructure.shiro.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date: 2023/5/28
 * @Author: Jonah Si
 * @Description: 用户服务实现类
 */
@Service
public class SeckillUserServiceImpl implements SeckillUserService {
    @Autowired
    private SeckillUserRepository seckillUserRepository;
    @Autowired
    private RedisService redisService;

    @Override
    public SeckillUser getSeckillUserByUserName(String userName) {
        return seckillUserRepository.getSeckillUserByUserName(userName);
    }

    @Override
    public String login(String userName, String password) {
        if (StringUtils.isEmpty(userName)) {
            throw new SeckillException(HttpCode.USERNAME_IS_NULL);
        }
        if (StringUtils.isEmpty(password)) {
            throw new SeckillException(HttpCode.PASSWORD_IS_NULL);
        }
        SeckillUser seckillUser = seckillUserRepository.getSeckillUserByUserName(userName);
        if (seckillUser == null) {
            throw new SeckillException(HttpCode.USERNAME_IS_ERROR);
        }
        String paramsPassword = CommonsUtils.encryptPassword(password, userName);
        if (!paramsPassword.equals(seckillUser.getPassword())) {
            throw new SeckillException(HttpCode.PASSWORD_IS_ERROR);
        }
        String token = JwtUtils.sign(seckillUser.getUserId());
        String key = SeckillConstants.getKey(SeckillConstants.USER_KEY_PREFIX, String.valueOf(seckillUser.getUserId()));

        // 缓存到Redis
        redisService.set(key, seckillUser);
        // 返回token
        return token;
    }
}
