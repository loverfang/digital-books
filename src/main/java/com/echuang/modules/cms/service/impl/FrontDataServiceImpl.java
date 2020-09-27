package com.echuang.modules.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsCategoryDTO;
import com.echuang.modules.cms.dto.CmsDataDTO;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import com.echuang.modules.cms.entity.CmsDataEntity;
import com.echuang.modules.cms.mapper.CmsCategoryMapper;
import com.echuang.modules.cms.mapper.CmsDataMapper;
import com.echuang.modules.cms.service.FrontDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 16:31
 * @Version 1.0
 */
@Service
public class FrontDataServiceImpl  extends ServiceImpl<CmsCategoryMapper, CmsCategoryEntity> implements FrontDataService {

    @Resource
    private CmsCategoryMapper cmsCategoryMapper;
    @Resource
    private CmsDataMapper cmsDataMapper;

    @Override
    public List<CmsCategoryDTO> categoryListByParentId(Long parentId) {
        List<CmsCategoryEntity> categoryEntityList = cmsCategoryMapper.selectList(new QueryWrapper<CmsCategoryEntity>()
                .eq("parent_id",parentId).eq("status",1).orderByAsc("priority"));
        List<CmsCategoryDTO> categoryDTOList = new ArrayList<>();
        if(categoryEntityList!=null && categoryEntityList.size()>0){
            for(CmsCategoryEntity entity: categoryEntityList){
                CmsCategoryDTO tempDTO = new CmsCategoryDTO();
                tempDTO.setCategoryId(entity.getCategoryId());
                tempDTO.setParentId(entity.getParentId());
                tempDTO.setCategoryName(entity.getCategoryName());
                tempDTO.setCategoryUrl(entity.getCategoryUrl());
                tempDTO.setCoverUrl( entity.getCoverUrl() );
                categoryDTOList.add(tempDTO);
            }
        }
        return categoryDTOList;
    }

    @Override
    public CmsCategoryDTO queryCategoryById(Long categoryId) {
        CmsCategoryDTO targetDTO = new CmsCategoryDTO();
        CmsCategoryEntity sourceEntity = cmsCategoryMapper.selectById(categoryId);
        BeanUtils.copyProperties(sourceEntity,targetDTO);
        return targetDTO;
    }

    @Override
    public PageUtils dataListByCategoryId(Long categoryId, Integer pageNo, Integer pageSize) {
        // 新建分页
        Page<Map<String,Object>> page = new Page<Map<String,Object>>(pageNo, pageSize);

        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("categoryId", categoryId);
        IPage<CmsDataEntity> pageResult = cmsDataMapper.queryPageList(page, queryMap);
        // 返回结果
        return new PageUtils(pageResult);
    }

    @Override
    public PageUtils searchDataList(String keyword, Integer page, Integer limit) {
        // 新建分页
        Page<Map<String,Object>> pagetag = new Page<Map<String,Object>>(page, limit);
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("name", keyword);
        IPage<CmsDataEntity> resultPage = cmsDataMapper.queryPageList(pagetag, queryMap);
        return new PageUtils(resultPage);
    }

    @Override
    public CmsDataDTO dataDetail(Long id) {
        CmsDataEntity result = cmsDataMapper.getCmsDataById(id);
        CmsDataDTO cmsDataDTO = new CmsDataDTO();
        if(result!=null){
            BeanUtils.copyProperties(result, cmsDataDTO);
            return cmsDataDTO;
        }
        return cmsDataDTO;
    }

}
