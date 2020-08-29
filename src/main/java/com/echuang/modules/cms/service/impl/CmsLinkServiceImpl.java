package com.echuang.modules.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.Query;
import com.echuang.modules.cms.entity.CmsLinkEntity;
import com.echuang.modules.cms.mapper.CmsLinkMapper;
import com.echuang.modules.cms.service.CmsLinkService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 9:04
 * @Version 1.0
 */
@Service("cmsLinkService")
public class CmsLinkServiceImpl extends ServiceImpl<CmsLinkMapper, CmsLinkEntity> implements CmsLinkService{

    @Override
    public PageUtils queryPageList(Map<String, Object> queryMap) {
        String linkName = (String)queryMap.get("name");
        IPage<CmsLinkEntity> page = this.page(
                new Query<CmsLinkEntity>().getPage(queryMap),
                new QueryWrapper<CmsLinkEntity>()
                        .like(StringUtils.isNotBlank(linkName), "name", linkName)
        );
        return new PageUtils(page);
    }

}
