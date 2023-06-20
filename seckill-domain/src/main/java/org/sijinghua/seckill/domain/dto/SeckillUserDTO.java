package org.sijinghua.seckill.domain.dto;

import java.io.Serializable;

/**
 * @Date: 2023/6/4
 * @Author: Jonah Si
 * @Description: 用户DTO
 */
public class SeckillUserDTO implements Serializable {
    private static final long serialVersionUID = 1576119726547415227L;

    // 用户名
    private String userName;
    // 密码
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
