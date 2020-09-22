package com.echuang.modules.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.entity.CmsLinkEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 9:04
 * @Version 1.0
 */
public interface CmsLinkService extends IService<CmsLinkEntity> {

    /**
     * 分页查询链接列表
     * @param queryMap
     * @return
     */
    PageUtils queryPageList(Map<String,Object> queryMap);

    int saveCmsLink(CmsLinkEntity cmsLink);

    int updateCmsLink(CmsLinkEntity cmsLink);

    int deleteCmsLink(List<Long> ids);

    CmsLinkEntity getCmsLinkById(Long id);
}
