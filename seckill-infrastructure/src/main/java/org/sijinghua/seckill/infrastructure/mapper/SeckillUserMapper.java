package org.sijinghua.seckill.infrastructure.mapper;

import org.apache.ibatis.annotations.Param;
import org.sijinghua.seckill.domain.model.SeckillUser;

/**
 * @Date: 2023/5/24
 * @Author: Jonah Si
 * @Description: 秒杀用户的Mapper接口
 */
public interface SeckillUserMapper {
    /**
     * 根据用户名获取用户信息
     */
    SeckillUser getSeckillUserByUserName(@Param("userName") String userName);
}
