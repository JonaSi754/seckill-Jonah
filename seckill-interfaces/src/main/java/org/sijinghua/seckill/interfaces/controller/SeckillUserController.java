package org.sijinghua.seckill.interfaces.controller;

import org.sijinghua.seckill.application.service.SeckillUserService;
import org.sijinghua.seckill.domain.code.HttpCode;
import org.sijinghua.seckill.domain.dto.SeckillUserDTO;
import org.sijinghua.seckill.domain.model.SeckillUser;
import org.sijinghua.seckill.domain.response.ResponseMessage;
import org.sijinghua.seckill.domain.response.ResponseMessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Date: 2023/5/28
 * @Author: Jonah Si
 * @Description: 用户服务Controller
 */
@RestController
@RequestMapping(value = "/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class SeckillUserController {
    @Autowired
    SeckillUserService seckillUserService;

    /**
     * 测试系统
     */
    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMessage<SeckillUser> getUser(@RequestParam("username") String userName) {
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(),
            seckillUserService.getSeckillUserByUserName(userName));
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMessage<String> login(@RequestBody SeckillUserDTO seckillUserDTO) {
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(),
            seckillUserService.login(seckillUserDTO.getUserName(), seckillUserDTO.getPassword()));
    }
}
