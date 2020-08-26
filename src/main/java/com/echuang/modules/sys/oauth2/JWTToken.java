package com.echuang.modules.sys.oauth2;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author Luo.z.x
 * @Date 2020/8/26 14:36
 * @Version 1.0
 */
public class JWTToken implements AuthenticationToken {
    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
