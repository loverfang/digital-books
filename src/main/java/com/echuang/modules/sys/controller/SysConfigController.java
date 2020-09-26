package com.echuang.modules.sys.controller;

import com.echuang.common.annotation.SysLog;
import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.ResultResponse;
import com.echuang.common.validator.ValidatorUtils;
import com.echuang.common.web.AbstractController;
import com.echuang.modules.sys.entity.SysConfigEntity;
import com.echuang.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 系统配置信息
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/sys/config")
public class SysConfigController extends AbstractController {
    @Resource
    private SysConfigService sysConfigService;

    /**
     * 所有配置列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:config:list")
    public ResultResponse list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysConfigService.queryPage(params);
        return ResultResponse.ok().put("page", page);
    }

    /**
     * 配置信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public ResultResponse info(@PathVariable("id") Long id) {
        SysConfigEntity config = sysConfigService.getById(id);
        return ResultResponse.ok().put("config", config);
    }

    /**
     * 保存配置
     */
    @SysLog("保存配置")
    @PostMapping("/save")
    @RequiresPermissions("sys:config:save")
    public ResultResponse save(@RequestBody SysConfigEntity config) {
        ValidatorUtils.validateEntity(config);
        sysConfigService.saveConfig(config);
        return ResultResponse.ok();
    }

    /**
     * 修改配置
     */
    @SysLog("修改配置")
    @PostMapping("/update")
    @RequiresPermissions("sys:config:update")
    public ResultResponse update(@RequestBody SysConfigEntity config) {
        ValidatorUtils.validateEntity(config);
        sysConfigService.update(config);
        return ResultResponse.ok();
    }

    /**
     * 删除配置
     */
    @SysLog("删除配置")
    @PostMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public ResultResponse delete(@RequestBody Long[] ids) {
        sysConfigService.deleteBatch(ids);
        return ResultResponse.ok();
    }

}
