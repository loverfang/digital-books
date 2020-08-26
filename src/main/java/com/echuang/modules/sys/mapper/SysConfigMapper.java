package com.echuang.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.echuang.modules.sys.entity.SysConfigEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 系统配置信息
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface SysConfigMapper extends BaseMapper<SysConfigEntity> {

    /**
     * 根据key，查询value
     */
    SysConfigEntity queryByKey(String paramKey);

    /**
     * 根据key，更新value
     */
    int updateValueByKey(@Param("paramKey") String paramKey, @Param("paramValue") String paramValue);

}
