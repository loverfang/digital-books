package com.echuang.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.ResultResponse;
import com.echuang.modules.sys.entity.SysUserTokenEntity;
import com.echuang.modules.sys.mapper.SysUserTokenMapper;
import com.echuang.modules.sys.oauth2.JWTUtil;
import com.echuang.modules.sys.service.SysUserTokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenMapper, SysUserTokenEntity> implements SysUserTokenService {
    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Override
    public ResultResponse createToken(String userName, long userId) {
        //生成一个token
        String token = JWTUtil.sign(userName, String.valueOf(userId));

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        SysUserTokenEntity tokenEntity = this.getById(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            this.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            this.updateById(tokenEntity);
        }

        ResultResponse r = ResultResponse.ok().put("token", token).put("expire", EXPIRE);

        return r;
    }

    @Override
    public void logout(String userName, long userId) {
        //生成一个token
        String token = JWTUtil.sign(userName, String.valueOf(userId));

        //修改token
        SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
    }
}
