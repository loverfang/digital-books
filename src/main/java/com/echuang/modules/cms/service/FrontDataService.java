package com.echuang.modules.cms.service;

import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsCategoryDTO;
import com.echuang.modules.cms.dto.CmsDataDTO;

import java.util.List;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 16:29
 * @Version 1.0
 */
public interface FrontDataService {
    List<CmsCategoryDTO> categoryListByParentId(Long parentId);
    PageUtils dataListByCategoryId(Long categoryId, Integer pageNo, Integer pageSize);
    CmsDataDTO dataDetail(Long id);
}
