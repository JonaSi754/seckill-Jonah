package org.sijinghua.seckill.domain.code;

/**
 * @Date: 2023/5/29
 * @Author: Jonah Si
 * @Description: Http状态码
 */
public enum HttpCode {
    SUCCESS(1001, "成功"),
    FAILURE(2001, "失败"),
    PARAM_INVALID(2002, "参数错误"),
    USERNAME_IS_NULL(2003, "用户名为空"),
    PASSWORD_IS_NULL(2004, "密码为空"),
    USERNAME_IS_ERROR(2005, "用户名错误"),
    PASSWORD_IS_ERROR(2006, "密码错误"),
    SERVER_EXCEPTION(2007, "服务器异常"),
    STOCK_LT_ZERO(2008, "剩余库存不足"),
    GOODS_NOT_EXISTS(2009, "商品不存在"),
    ACTIVITY_NOT_EXISTS(2010, "活动不存在"),
    BEYOND_LIMIT_NUM(2011, "购买数量超出限制"),
    USER_NOT_LOGIN(2012, "用户未登录"),
    TOKEN_EXPIRE(2013, "Token失效"),
    GOODS_OFFLINE(2014, "商品已下线"),
    GOODS_NOT_PUBLISHED(2015, "商品未上线"),
    DATA_PARSE_FAILED(2016, "数据解析失败"),
    ;

    private final Integer code;
    private final String message;

    HttpCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
