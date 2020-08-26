package com.echuang.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.echuang.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface SysUserTokenMapper extends BaseMapper<SysUserTokenEntity> {

    SysUserTokenEntity queryByToken(String token);

}
