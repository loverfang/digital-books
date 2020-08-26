package com.echuang.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.echuang.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
@Mapper
@CacheNamespace(flushInterval = 300000L) //缓存五分钟过期
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);

}
