package org.sijinghua.seckill.domain.repository;

import org.sijinghua.seckill.domain.model.SeckillUser;

/**
 * @Date: 2023/5/23
 * @Author: Jonah Si
 * @Description: 用户仓库接口
 */
public interface SeckillUserRepository {
    SeckillUser getSeckillUserByUserName(String userName);
}
