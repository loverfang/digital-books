package com.echuang.modules.cms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.exception.RRException;
import com.echuang.modules.cms.service.FrontConfigService;
import com.echuang.modules.sys.entity.SysConfigEntity;
import com.echuang.modules.sys.mapper.SysConfigMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class FrontConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfigEntity> implements FrontConfigService {

    @Override
    public String getValue(String key) {
        SysConfigEntity config = baseMapper.queryByKey(key);
        return config == null ? null : config.getParamValue();
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key);
        if (StringUtils.isNotBlank(value)) {
            return JSON.parseObject(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RRException("获取参数失败");
        }
    }
}
