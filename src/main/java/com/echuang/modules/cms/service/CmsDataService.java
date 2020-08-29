package com.echuang.modules.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.entity.CmsDataEntity;

import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 10:16
 * @Version 1.0
 */
public interface CmsDataService extends IService<CmsDataEntity> {

    PageUtils queryPageList(Map<String,Object> queryMap);

    void saveCmsData(CmsDataEntity cmsDataEntity);

    void saveOrUpdateCmsData(CmsDataEntity cmsDataEntity);

    CmsDataEntity getCmsDataById(Long id);

    void updateStatusBatchByMap(Map<String, Object> param);
}
