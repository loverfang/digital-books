package com.echuang.modules.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.Query;
import com.echuang.modules.cms.entity.CmsNoticeEntity;
import com.echuang.modules.cms.mapper.CmsNoticeMapper;
import com.echuang.modules.cms.service.CmsNoticeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 9:04
 * @Version 1.0
 */
@Service("cmsLinkService")
public class CmsNoticeServiceImpl extends ServiceImpl<CmsNoticeMapper, CmsNoticeEntity> implements CmsNoticeService {

    @Override
    public PageUtils queryPageList(Map<String, Object> queryMap) {
        String title = (String)queryMap.get("title");
        IPage<CmsNoticeEntity> page = this.page(
                new Query<CmsNoticeEntity>().getPage(queryMap),
                new QueryWrapper<CmsNoticeEntity>()
                        .like(StringUtils.isNotBlank(title), "title", title)
        );
        return new PageUtils(page);
    }

    @Override
    public int saveCmsNotice(CmsNoticeEntity cmsNotice) {
        return this.baseMapper.insert( cmsNotice );
    }

    @Override
    public int updateCmsNotice(CmsNoticeEntity cmsNotice) {
        return this.baseMapper.updateById(cmsNotice);
    }

    @Override
    public int deleteCmsNotice(List<Long> ids) {
        return this.baseMapper.deleteBatchIds(ids);
    }

}
