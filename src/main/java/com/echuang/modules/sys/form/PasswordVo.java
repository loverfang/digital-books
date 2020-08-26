package com.echuang.modules.sys.form;

/**
 * 密码表单
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
public class PasswordVo {
    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
