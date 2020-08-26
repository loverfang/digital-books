package com.echuang.modules.sys.controller;

import com.echuang.common.annotation.SysLog;
import com.echuang.common.utils.Constant;
import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.ResultResponse;
import com.echuang.common.validator.ValidatorUtils;
import com.echuang.modules.sys.entity.SysRoleEntity;
import com.echuang.modules.sys.service.SysRoleMenuService;
import com.echuang.modules.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 角色列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:role:list")
    public ResultResponse list(@RequestParam Map<String, Object> params) {
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }
        PageUtils page = sysRoleService.queryPage(params);
        return ResultResponse.ok().put("page", page);
    }

    /**
     * 角色列表
     */
    @GetMapping("/select")
    @RequiresPermissions("sys:role:select")
    public ResultResponse select() {
        Map<String, Object> map = new HashMap<>();
        //如果不是超级管理员，则只查询自己所拥有的角色列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            map.put("create_user_id", getUserId());
        }
        List<SysRoleEntity> list = (List<SysRoleEntity>) sysRoleService.listByMap(map);

        return ResultResponse.ok().put("list", list);
    }

    /**
     * 角色信息
     */
    @GetMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public ResultResponse info(@PathVariable("roleId") Long roleId) {
        SysRoleEntity role = sysRoleService.getById(roleId);
        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        role.setMenuIdList(menuIdList);
        return ResultResponse.ok().put("role", role);
    }

    /**
     * 保存角色
     */
    @SysLog("保存角色")
    @PostMapping("/save")
    @RequiresPermissions("sys:role:save")
    public ResultResponse save(@RequestBody SysRoleEntity role) {
        ValidatorUtils.validateEntity(role);
        role.setCreateUserId(getUserId());
        sysRoleService.saveRole(role);
        return ResultResponse.ok();
    }

    /**
     * 修改角色
     */
    @SysLog("修改角色")
    @PostMapping("/update")
    @RequiresPermissions("sys:role:update")
    public ResultResponse update(@RequestBody SysRoleEntity role) {
        ValidatorUtils.validateEntity(role);
        role.setCreateUserId(getUserId());
        sysRoleService.update(role);
        return ResultResponse.ok();
    }

    /**
     * 删除角色
     */
    @SysLog("删除角色")
    @PostMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public ResultResponse delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);
        return ResultResponse.ok();
    }
}
