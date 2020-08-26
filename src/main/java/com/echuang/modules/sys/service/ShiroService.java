package com.echuang.modules.sys.service;

import com.echuang.modules.sys.entity.SysUserEntity;
import com.echuang.modules.sys.entity.SysUserTokenEntity;

import java.util.Set;

/**
 * @Author Luo.z.x
 * @Date 2020/8/26 16:52
 * @Version 1.0
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    /**
     * 根据Token查询用户信息
     * @param token
     * @return
     */
    SysUserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUserEntity queryUser(Long userId);
}
