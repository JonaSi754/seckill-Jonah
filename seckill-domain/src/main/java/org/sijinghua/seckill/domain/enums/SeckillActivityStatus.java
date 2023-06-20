package org.sijinghua.seckill.domain.enums;

/**
 * @Date: 2023/5/15
 * @Author: Jonah Si
 * @Description: 活动状态枚举类
 */
public enum SeckillActivityStatus {

    PUBLISHED(0),
    ONLINE(1),
    OFFLINE(-1),
    ;

    private final Integer code;

    SeckillActivityStatus(Integer code) {
        this.code = code;
    }

    public boolean isOnline(Integer status) {
        return ONLINE.getCode().equals(status);
    }

    public boolean isOffline(Integer status) {
        return OFFLINE.getCode().equals(status);
    }

    public Integer getCode() {
        return code;
    }
}
