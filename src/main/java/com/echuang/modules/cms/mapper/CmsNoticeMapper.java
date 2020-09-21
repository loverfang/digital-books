package com.echuang.modules.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.echuang.modules.cms.entity.CmsNoticeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 11:12
 * @Version 1.0
 */
@Mapper
public interface CmsNoticeMapper extends BaseMapper<CmsNoticeEntity> {
    List<Map<String,Object>> queryPageList(Page<Map<String,Object>> page, @Param("paramMap") Map<String,Object> paramMap);
}
