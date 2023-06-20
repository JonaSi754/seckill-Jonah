package org.sijinghua.seckill.infrastructure.repository;

import org.sijinghua.seckill.domain.model.SeckillUser;
import org.sijinghua.seckill.domain.repository.SeckillUserRepository;
import org.sijinghua.seckill.infrastructure.mapper.SeckillUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date: 2023/5/28
 * @Author: Jonah Si
 * @Description: 用户仓库实现类
 */
@Component
public class SeckillUserRepositoryImpl implements SeckillUserRepository {
    @Autowired
    private SeckillUserMapper seckillUserMapper;

    @Override
    public SeckillUser getSeckillUserByUserName(String userName) {
        return seckillUserMapper.getSeckillUserByUserName(userName);
    }
}
