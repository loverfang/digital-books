package com.echuang.modules.cms.websitecontroller;

import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsCategoryDTO;
import com.echuang.modules.cms.dto.CmsDataDTO;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import com.echuang.modules.cms.service.FrontDataService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value={"/list/{parentId}/{categoryId}/"} )
    public String list(@PathVariable("parentId") Long parentId, @PathVariable("categoryId") Long categoryId, Integer pageNo, Integer pageSize){
        // 内容分页列表
        Integer page = pageNo==null?1:pageNo;
        Integer limit = pageSize==null?10:pageSize;

        // 左侧同级列表
        List<CmsCategoryDTO>  categoryDTOList = categoryListByParentId(parentId);
        Map<String, Object> result = new HashMap<>();
        result.put("categoryList", categoryDTOList);

        PageUtils resultPage = frontDataService.dataListByCategoryId(categoryId, page, limit);
        result.put("page", resultPage);
        if(5 == parentId){
            return "website/qikan_list";
        }
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
        return  frontDataService.categoryListByParentId(parentId);
    }

}
