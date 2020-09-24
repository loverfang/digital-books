package com.echuang.modules.cms.websitecontroller;

import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsCategoryDTO;
import com.echuang.modules.cms.dto.CmsDataDTO;
import com.echuang.modules.cms.dto.CmsLinkDTO;
import com.echuang.modules.cms.dto.CmsNoticeDTO;
import com.echuang.modules.cms.entity.CmsNoticeEntity;
import com.echuang.modules.cms.service.FrontDataService;
import com.echuang.modules.cms.service.FrontLinksService;
import com.echuang.modules.cms.service.FrontNoticeService;
import org.apache.shiro.crypto.hash.Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/9/15 9:50
 * @Version 1.0
 */
@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private FrontNoticeService frontNoticeService;

    @Resource
    private FrontLinksService frontLinksService;

    @Resource
    private FrontDataService frontDataService;

    /**
     * 进入首页方法
     * @return
     */
    @GetMapping(value={"/", "index"})
    public String index(HttpServletRequest request){
        logger.info("enter index ...");
        Map<String,Object> dataMap = new HashMap<>();
        // 中文期刊数据库
        List<CmsCategoryDTO> chinaList = childCategoryList(1L);
        dataMap.put("chinaList", chinaList);
        // 外文期刊数据库
        List<CmsCategoryDTO> foreignList = childCategoryList(2L);
        dataMap.put("foreignList", foreignList);

        // 情报中心产品
        CmsCategoryDTO centerCategory = new CmsCategoryDTO(3L,0L,"情报中心产品");
        fileDataList(centerCategory);
        dataMap.put("centerCategory", centerCategory);

        // 集团中心产品
        CmsCategoryDTO companyCategory = new CmsCategoryDTO(4L,0L,"集团情报产品");
        fileDataList(companyCategory);
        dataMap.put("companyCategory", companyCategory);

        // 外购列表
        CmsCategoryDTO outerBuyCategory = new CmsCategoryDTO(6L,0L,"外购报告");
        fileDataList(outerBuyCategory);
        dataMap.put("outerBuyCategory", outerBuyCategory);

        // 刊物
        List<CmsCategoryDTO> publicationList = childCategoryList(5L);
        dataMap.put("publicationList", publicationList);

        // 公告
        dataMap.put("noticeList", noticeIndexList());
        // 友情链接
        dataMap.put("linkList", linkIndexList());

        request.setAttribute("root", dataMap);
        return "website/index";
    }

    /**
     * 通用查询方法
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(@RequestParam(required = true) String keyword, @RequestParam(required = false)Integer pageNo, @RequestParam(required = false)Integer pageSize){
        // 内容分页列表
        Integer page = pageNo==null?1:pageNo;
        Integer limit = pageSize==null?10:pageSize;
        frontDataService.searchDataList(keyword, page, limit);
        return "website/search_result";
    }

    /**
     * 查询类型下的文件信息，如果有子类比就查询子类别下的数据信息,没有子类别就查他自己下的数据信息
     * @param categoryDTO
     */
    private void fileDataList(CmsCategoryDTO categoryDTO){
        List<CmsCategoryDTO> centerList = childCategoryList(categoryDTO.getCategoryId());
        if(centerList!=null && centerList.size()>0){
            categoryDTO.setChildList(centerList);
            // 只有子类别
            centerList.forEach(item -> {
                // 根据类型ID查询资料列表
                PageUtils resultPage = frontDataService.dataListByCategoryId(item.getCategoryId(),1, 10);
                List<Map<String,Object>> resultList = (List<Map<String,Object>>)resultPage.getList();
                item.setDataList( maplistToDTOList(resultList) );
            });
        }else{
            // 没有子类型就填充他自身的类别信息
            categoryDTO.setChildList(new ArrayList<>());
            PageUtils resultPage = frontDataService.dataListByCategoryId(categoryDTO.getCategoryId(),1, 10);
            List<Map<String,Object>> resultList = (List<Map<String,Object>>)resultPage.getList();
            categoryDTO.setDataList( maplistToDTOList(resultList));
        }
    }

    /**
     * Map转成想要的数据类型
     * @param oldMapList
     * @return
     */
    private List<CmsDataDTO> maplistToDTOList(List<Map<String,Object>> oldMapList){
        List<CmsDataDTO> resultDataList = new ArrayList<>();
        if(oldMapList == null || oldMapList.size()<=0){
            return resultDataList;
        }
        oldMapList.forEach(item ->{
            CmsDataDTO tempDTO = new CmsDataDTO();
            tempDTO.setDataId( Long.valueOf((String)item.get("dataId")));
            tempDTO.setCategoryId( Long.valueOf((String)item.get("categoryId")));
            tempDTO.setName((String)item.get("name"));
            resultDataList.add(tempDTO);
        });
        return resultDataList;
    }

    /**
     * 查询同级类别列表
     * @param categoryId
     * @return
     */
    private List<CmsCategoryDTO> childCategoryList(Long categoryId){
        return  frontDataService.categoryListByParentId(categoryId);
    }

    /**
     * 通知列表
     * @return
     */
    private List<Map<String,Object>> noticeIndexList(){
        PageUtils page = frontNoticeService.noticeList(1, 6);
        List<Map<String,Object>> noticeMapList = (List<Map<String,Object>>)page.getList();
        return noticeMapList;
    }

    /**
     * 友情连接列表
     * @return
     */
    private List<CmsLinkDTO> linkIndexList(){
        return frontLinksService.allLinksList();
    }

}
