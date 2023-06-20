package org.sijinghua.seckill.domain.model;

import java.io.Serializable;

/**
 * @Date: 2023/5/15
 * @Author: Jonah Si
 * @Description: 秒杀用户实体类
 */
public class SeckillUser implements Serializable {
    private static final long serialVersionUID = -3004624289691589697L;

    // 用户id
    private Long userId;

    // 用户名
    private String userName;

    // 密码
    private String password;

    // 状态  0：正常  1：冻结
    private Integer status;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
