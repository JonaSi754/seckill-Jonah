package org.sijinghua.seckill.domain.exception;

import org.sijinghua.seckill.domain.code.HttpCode;

/**
 * @Date: 2023/6/4
 * @Author: Jonah Si
 * @Description: 秒杀异常类
 */
public class SeckillException extends RuntimeException {
    private Integer code;

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SeckillException(HttpCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
