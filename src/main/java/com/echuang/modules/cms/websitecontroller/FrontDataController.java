package com.echuang.modules.cms.websitecontroller;

import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsCategoryDTO;
import com.echuang.modules.cms.dto.CmsDataDTO;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import com.echuang.modules.cms.service.FrontConfigService;
import com.echuang.modules.cms.service.FrontDataService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class FrontDataController {

    @Resource
    FrontDataService frontDataService;
    @Resource
    FrontConfigService frontConfigService;

    @GetMapping(value={"/list/{parentId}/{categoryId}.html"} )
    public String list(HttpServletRequest request,
                       @PathVariable("parentId") Long parentId,
                       @PathVariable("categoryId") Long categoryId,
                       @RequestParam(name = "pageNo",required = false) Integer pageNo,
                       @RequestParam(name = "pageSize",required = false) Integer pageSize){
        // 内容分页列表
        Integer page = pageNo==null?1:pageNo;
        Integer limit = pageSize==null?frontConfigService.getConfigObject("pageSize",Integer.class):pageSize;
        Map<String, Object> result = new HashMap<>();

        // 左侧同级列表
        List<CmsCategoryDTO> categoryDTOList = null;
        if(parentId == 0) {
            // 一级类别不需要查同级列表
            categoryDTOList = new ArrayList<>();
            CmsCategoryDTO selfNav = frontDataService.queryCategoryById(categoryId);
            categoryDTOList.add(selfNav);
            result.put("navId", categoryId);
        }else{
            categoryDTOList = categoryListByParentId(parentId);
            result.put("navId", parentId);
        }


        // 左侧导航列表
        result.put("categoryList", categoryDTOList);
        PageUtils resultPage = frontDataService.dataListByCategoryId(categoryId, page, limit);
        // 分页数据
        result.put("page", resultPage);

        // 导航标记
        result.put("parentId", parentId);

        result.put("currCategoryId", categoryId);

        request.setAttribute("root", result);
        if(5 == parentId){
            // 期刊页面
            return "website/qikan_list";
        }

        // 其它类别的页面
        return "website/product_list";
    }

    @GetMapping("/detail/{id}.html")
    public String detail(HttpServletRequest request, @PathVariable("id") Long id){
        CmsDataDTO cmsDataDTO = frontDataService.dataDetail( id );

        CmsCategoryDTO selfNav = frontDataService.queryCategoryById( cmsDataDTO.getCategoryId() );

        Map<String, Object> result = new HashMap<>();
        // 左侧同级列表
        List<CmsCategoryDTO> categoryDTOList = null;
        if(selfNav.getParentId() == 0) {
            categoryDTOList = new ArrayList<>();
            // 一级类别不需要查同级列表
            categoryDTOList.add(selfNav);
            result.put("navId", selfNav.getCategoryId());
        }else{
            categoryDTOList = categoryListByParentId( selfNav.getParentId() );
            result.put("navId", selfNav.getParentId() );
        }

        // 左侧导航列表
        result.put("categoryList", categoryDTOList);
        // 导航标记
        result.put("currCategoryId", selfNav.getCategoryId());
        // 详情信息
        result.put("dataInfo", cmsDataDTO);

        request.setAttribute("root", result);
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
