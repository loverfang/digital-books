package com.echuang.modules.cms.websitecontroller;

import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsCategoryDTO;
import com.echuang.modules.cms.dto.CmsDataDTO;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import com.echuang.modules.cms.service.FrontDataService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class FrontDataController {

    @Resource
    FrontDataService frontDataService;

    @GetMapping("/list")
    public String list(@RequestParam(required = false) Long parentId, @RequestParam(required = false) Long categoryId, Integer page, Integer limit){
        // 左侧同级列表
        List<CmsCategoryDTO>  categoryDTOList = categoryListByParentId(parentId);
        Map<String, Object> result = new HashMap<>();
        result.put("categoryList", categoryDTOList);

        // 内容分页列表
        Integer pageNo = page==null?1:page;
        Integer pageSize = limit==null?10:limit;

        PageUtils resultPage = frontDataService.dataListByCategoryId(categoryId, pageNo, pageSize);
        result.put("page", resultPage);
        return "website/product_list";
    }

    @GetMapping("/detail")
    public String detail(Long id){
        Map<String, Object> result = new HashMap<>();

        CmsDataDTO cmsDataDTO = frontDataService.dataDetail( id );
        result.put("dataInfo", cmsDataDTO);

        return "website/product_detail";
    }

    /**
     * 查询同级类别列表
     * @param parentId
     * @return
     */
    private List<CmsCategoryDTO> categoryListByParentId(Long parentId){
        List<CmsCategoryEntity> categoryEntityList = frontDataService.categoryListByParentId(parentId);
        List<CmsCategoryDTO> categoryDTOList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(categoryEntityList) && categoryEntityList.size()>0){
            for(CmsCategoryEntity category : categoryEntityList){
                CmsCategoryDTO categoryDTO = new CmsCategoryDTO();
                categoryDTO.setCategoryId(category.getCategoryId());
                categoryDTO.setCategoryName(category.getCategoryName());
                categoryDTO.setCategoryUrl(category.getCategoryUrl());
                categoryDTOList.add(categoryDTO);
            }
        }
        return categoryDTOList;
    }
}
