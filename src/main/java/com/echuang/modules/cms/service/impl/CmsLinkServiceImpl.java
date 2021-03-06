package com.echuang.modules.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.Query;
import com.echuang.common.utils.SnowflakeIdWorker;
import com.echuang.modules.cms.entity.CmsLinkEntity;
import com.echuang.modules.cms.mapper.CmsLinkMapper;
import com.echuang.modules.cms.service.CmsLinkService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 9:04
 * @Version 1.0
 */
@Service
public class CmsLinkServiceImpl extends ServiceImpl<CmsLinkMapper, CmsLinkEntity> implements CmsLinkService{

    @Override
    public PageUtils queryPageList(Map<String, Object> queryMap) {
        String linkName = (String)queryMap.get("name");
        IPage<CmsLinkEntity> page = this.page(
                new Query<CmsLinkEntity>().getPage(queryMap),
                new QueryWrapper<CmsLinkEntity>()
                        .like(StringUtils.isNotBlank(linkName), "name", linkName)
                .orderByAsc("priority")
        );
        return new PageUtils(page);
    }

    @Override
    public int saveCmsLink(CmsLinkEntity cmsLink) {
        // 保存基本信息
        Long linkId = SnowflakeIdWorker.getSnowflakeId();
        cmsLink.setLinkId( linkId );
        cmsLink.setStatus(1);
        return this.baseMapper.insert( cmsLink );
    }

    @Override
    public int updateCmsLink(CmsLinkEntity cmsLink) {
        return this.baseMapper.updateById(cmsLink);
    }

    @Override
    public int deleteCmsLink(List<Long> ids) {
        return this.baseMapper.deleteBatchIds(ids);
    }

    @Override
    public CmsLinkEntity getCmsLinkById(Long id) {
        return this.baseMapper.selectById(id);
    }
}
