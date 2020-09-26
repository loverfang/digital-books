package com.echuang.modules.sys.controller;

import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.ResultResponse;
import com.echuang.modules.sys.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;


/**
 * 系统日志
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
@Controller
@RequestMapping("/api/sys/log")
public class SysLogController {
    @Resource
    private SysLogService sysLogService;

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("sys:log:list")
    public ResultResponse list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysLogService.queryPage(params);
        return ResultResponse.ok().put("page", page);
    }

}
