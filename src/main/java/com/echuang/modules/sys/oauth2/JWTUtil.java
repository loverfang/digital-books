package com.echuang.modules.sys.oauth2;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @Author Luo.z.x
 * @Date 2020/8/26 14:38
 * @Version 1.0
 */
@Component
public class JWTUtil {

    /**
     *过期时间
     */
    private static Long expire;

    /**
     * 秘钥
     */
    private static String secret;

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @return 是否正确
     */
    public static boolean verify(String token, String userName) {
        //根据密码生成JWT效验器
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withClaim("userName", userName)
                .build();
        //效验TOKEN
        verifier.verify(token);
        return true;
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获取用户id
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param userName 用户名
     * @param userId
     * @return 加密的token
     */
    public static String sign(String userName, String userId) {
        try {
            Date date = new Date(System.currentTimeMillis() + expire * 1000);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim("userName", userName)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }

    public static Long getExpire() {
        return expire;
    }
    @Value("${echuang.jwt.expire}")
    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public static String getSecret() {
        return secret;
    }

    @Value("${echuang.jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }
}
