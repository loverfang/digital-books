package com.echuang.modules.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.echuang.modules.cms.entity.CmsDataFileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 11:11
 * @Version 1.0
 */
@Mapper
public interface CmsDataFileMapper extends BaseMapper<CmsDataFileEntity>{
   Integer insertBatchDataFiles(@Param("fileList") List<CmsDataFileEntity> list);
   Integer deleteDataFilesByDataId(Long dataId);
}
