package com.echuang.modules.cms.service;

import com.echuang.modules.cms.dto.CmsLinkDTO;

import java.util.List;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 16:29
 * @Version 1.0
 */
public interface FrontLinksService {
    List<CmsLinkDTO> allLinksList();
}
