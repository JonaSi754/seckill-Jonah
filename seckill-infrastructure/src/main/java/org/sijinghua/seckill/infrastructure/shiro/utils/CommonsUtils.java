package org.sijinghua.seckill.infrastructure.shiro.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Date: 2023/6/5
 * @Author: Jonah Si
 * @Description: 通用工具类
 */
public class CommonsUtils {

    /**
     * 手机号正则校验
     * @param phone 手机号码
     * @return 校验是否成功
     */
    public static boolean phoneRegexCheck(String phone) {
        return phone.length() == 11;
    }

    /**
     * 获取六位数验证码
     * @return 验证码
     */
    public static int getCode() {
        return (int) ((Math.random() * 9 + 1) * 100000);
    }

    /**
     * 使用MD5加密
     * @param password      需要加密的密码
     * @param phoneNumber   用户手机号
     * @return  加密后的密码
     */
    public static String encryptPassword(String password, String phoneNumber) {
        return String.valueOf(new SimpleHash("MD5", password, phoneNumber, 1024));
    }
}
