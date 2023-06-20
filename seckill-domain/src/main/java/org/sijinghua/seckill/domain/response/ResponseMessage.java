package org.sijinghua.seckill.domain.response;

import java.io.Serializable;

/**
 * @Date: 2023/5/15
 * @Author: Jonah Si
 * @Description: 响应数据
 */
public class ResponseMessage<T> implements Serializable {

    private Integer code;
    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(Integer code) {
        this.code = code;
    }

    public ResponseMessage(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
