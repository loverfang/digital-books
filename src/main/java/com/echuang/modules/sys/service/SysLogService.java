package com.echuang.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.sys.entity.SysLogEntity;

import java.util.Map;

/**
 * 系统日志
 * @Author Luo.z.x
 * @Date 2020/8/26 12:37
 * @Version 1.0
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
