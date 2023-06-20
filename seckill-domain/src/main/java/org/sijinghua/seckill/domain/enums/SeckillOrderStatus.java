package org.sijinghua.seckill.domain.enums;

/**
 * @Date: 2023/5/15
 * @Author: Jonah Si
 * @Description: 订单状态枚举类
 */
public enum SeckillOrderStatus {

    CREATED(1),
    PAID(2),
    CANCELED(0),
    DELETED(-1),
    ;

    private final Integer code;

    SeckillOrderStatus(Integer code) {
        this.code = code;
    }

    public boolean isCanceled(Integer status) {
        return CANCELED.getCode().equals(status);
    }

    public boolean isDeleted(Integer status) {
        return DELETED.getCode().equals(status);
    }

    public Integer getCode() {
        return code;
    }
}
