package com.echuang.modules.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.modules.cms.dto.CmsLinkDTO;
import com.echuang.modules.cms.entity.CmsLinkEntity;
import com.echuang.modules.cms.mapper.CmsLinkMapper;
import com.echuang.modules.cms.service.FrontLinksService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 18:16
 * @Version 1.0
 */
@Service
public class FrontLinksServiceImpl extends ServiceImpl<CmsLinkMapper, CmsLinkEntity> implements FrontLinksService {

    @Resource
    CmsLinkMapper cmsLinkMapper;
    @Override
    public List<CmsLinkDTO> allLinksList() {
        List<CmsLinkEntity> entityList = cmsLinkMapper.selectList(new QueryWrapper<CmsLinkEntity>().orderByAsc("link_id"));
        List<CmsLinkDTO> linkDTOList = new ArrayList<>();
        if( entityList!=null && entityList.size()> 0){
            for(CmsLinkEntity entity: entityList){
                CmsLinkDTO cmsLinkDTO = new CmsLinkDTO();
                BeanUtils.copyProperties(entity, cmsLinkDTO);
                linkDTOList.add(cmsLinkDTO);
            }
        }
        return linkDTOList;
    }

}
