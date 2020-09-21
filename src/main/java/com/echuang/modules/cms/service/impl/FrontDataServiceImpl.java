package com.echuang.modules.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsDataDTO;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import com.echuang.modules.cms.entity.CmsDataEntity;
import com.echuang.modules.cms.mapper.CmsCategoryMapper;
import com.echuang.modules.cms.mapper.CmsDataMapper;
import com.echuang.modules.cms.service.FrontDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<CmsCategoryEntity> categoryListByParentId(Long parentId) {
        return cmsCategoryMapper.selectList(new QueryWrapper<CmsCategoryEntity>().eq("parent_id",parentId));
    }

    @Override
    public PageUtils dataListByCategoryId(Long categoryId, Integer pageNo, Integer pageSize) {
        // 新建分页
        Page<Map<String,Object>> page = new Page<Map<String,Object>>(pageNo, pageSize);

        // 返回结果
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("categoryId", categoryId);
        List<Map<String,Object>> resultList = cmsCategoryMapper.queryPageList(page, queryMap);
        return  new PageUtils(page.setRecords(resultList));
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
