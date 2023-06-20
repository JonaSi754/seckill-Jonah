package org.sijinghua.seckill.infrastructure.handler.exception;

import org.sijinghua.seckill.domain.code.HttpCode;
import org.sijinghua.seckill.domain.exception.SeckillException;
import org.sijinghua.seckill.domain.response.ResponseMessage;
import org.sijinghua.seckill.domain.response.ResponseMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Date: 2023/6/4
 * @Author: Jonah Si
 * @Description: 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 全局异常处理，统一返回状态码
     */
    @ExceptionHandler(SeckillException.class)
    public ResponseMessage<String> handleSeckillException(SeckillException e) {
        logger.error("服务器抛出了异常：", e);
        return ResponseMessageBuilder.build(e.getCode(), e.getMessage());
    }

    /**
     * 全局异常处理，统一返回状态码
     */
    @ExceptionHandler(Exception.class)
    public ResponseMessage<String> handleException(Exception e) {
        logger.error("服务器抛出了异常：", e);
        return ResponseMessageBuilder.build(HttpCode.SERVER_EXCEPTION.getCode(), e.getMessage());
    }
}
