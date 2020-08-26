package com.echuang.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 角色
 * @Author Luo.z.x
 * @Date 2020/8/26 12:37
 * @Version 1.0
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveRole(SysRoleEntity role);

    void update(SysRoleEntity role);

    void deleteBatch(Long[] roleIds);


    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
}
