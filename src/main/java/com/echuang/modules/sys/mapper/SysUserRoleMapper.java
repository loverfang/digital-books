package com.echuang.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.echuang.modules.sys.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户与角色对应关系
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);


    /**
     * 根据角色ID数组，批量删除
     */
    int deleteBatch(Long[] roleIds);
}
