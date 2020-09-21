package com.echuang.modules.cms.service;

import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsNoticeDTO;

import java.util.List;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 17:16
 * @Version 1.0
 */
public interface FrontNoticeService {
    PageUtils noticeList(Integer pageNo, Integer pageSize);
    CmsNoticeDTO noticeDetail(Long id);
}
