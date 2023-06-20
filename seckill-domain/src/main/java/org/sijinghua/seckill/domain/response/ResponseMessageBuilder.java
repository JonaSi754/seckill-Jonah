package org.sijinghua.seckill.domain.response;

/**
 * @Date: 2023/5/16
 * @Author: Jonah Si
 * @Description: 响应消息构造类
 */
public class ResponseMessageBuilder {

    public static <T> ResponseMessage<T> build(Integer code, T body) {
        return new ResponseMessage<T>(code, body);
    }

    public static <T> ResponseMessage<T> build(Integer code) {
        return new ResponseMessage<T>(code);
    }
}
