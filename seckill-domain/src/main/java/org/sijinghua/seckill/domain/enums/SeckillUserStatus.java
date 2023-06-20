package org.sijinghua.seckill.domain.enums;

/**
 * @Date: 2023/5/15
 * @Author: Jonah Si
 * @Description: 用户状态枚举类
 */
public enum SeckillUserStatus {

    NORMAL(0),
    FREEZE(1),
    ;

    private final Integer code;

    SeckillUserStatus(Integer code) {
        this.code = code;
    }

    public boolean isNormal(Integer status) {
        return NORMAL.getCode().equals(status);
    }

    public Integer getCode() {
        return code;
    }
}
