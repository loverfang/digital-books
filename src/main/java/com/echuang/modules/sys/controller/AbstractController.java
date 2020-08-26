package com.echuang.modules.sys.controller;

import com.echuang.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 * @Author Luo.z.x
 * @Date 2020/8/26 12:37
 * @Version 1.0
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected SysUserEntity getUser() {
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }
    protected Long getUserId() {
        return getUser().getUserId();
    }
}
