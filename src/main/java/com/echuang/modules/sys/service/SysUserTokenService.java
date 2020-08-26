package com.echuang.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.echuang.common.utils.ResultResponse;
import com.echuang.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 * @Author Luo.z.x
 * @Date 2020/8/26 12:37
 * @Version 1.0
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    /**
     * 生成token
     * @param userId  用户ID
     */
    ResultResponse createToken(String userName, long userId);

    /**
     * 退出，修改token值
     * @param userId  用户ID
     */
    void logout(String userName, long userId);

}
