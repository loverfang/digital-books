package com.echuang.modules.sys.form;

import java.io.Serializable;

/**
 * 登录表单
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
public class SysLoginVo implements Serializable {
    private String username;
    private String password;
    private String captcha;
    private String uuid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
