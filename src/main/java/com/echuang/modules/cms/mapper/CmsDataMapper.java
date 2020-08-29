package com.echuang.modules.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.echuang.modules.cms.entity.CmsDataEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 10:17
 * @Version 1.0
 */
@Mapper
@CacheNamespace(flushInterval = 10 * 1000L) //缓存五分钟过期
public interface CmsDataMapper extends BaseMapper<CmsDataEntity> {

    /**
     * 自定义的分页查询
     * @param page
     * @param paramMap
     * @return
     */
    List<CmsDataEntity> queryPageList(@Param("page") IPage page, @Param("params")Map<String,Object> paramMap);

    /**
     * 加载资料详情
     * @param id
     * @return
     */
    CmsDataEntity getCmsDataById(Long id);

    void updateStatusBatchByMap(Map<String, Object> param);
}
