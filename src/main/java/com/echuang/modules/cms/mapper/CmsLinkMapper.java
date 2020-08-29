package com.echuang.modules.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.entity.CmsLinkEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 9:05
 * @Version 1.0
 */
@Mapper
public interface CmsLinkMapper extends BaseMapper<CmsLinkEntity> {
    PageUtils pageQuery();
}
