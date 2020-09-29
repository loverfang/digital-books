package com.echuang.modules.cms.websitecontroller;

import com.echuang.common.exception.RRException;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsCategoryDTO;
import com.echuang.modules.cms.dto.CmsDataDTO;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import com.echuang.modules.cms.entity.CmsDataFileEntity;
import com.echuang.modules.cms.service.FrontConfigService;
import com.echuang.modules.cms.service.FrontDataService;
import com.echuang.modules.oss.controller.OssController;
import com.echuang.modules.oss.service.OssService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class FrontDataController {

    private final static Logger logger = LoggerFactory.getLogger(OssController.class);

    @Resource
    FrontDataService frontDataService;
    @Resource
    FrontConfigService frontConfigService;
    @Resource
    private OssService ossService;

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

        if(parentId == 2 || parentId == 1){
            // 外连接子类别,也就是他自己的子类别
            // CmsCategoryDTO selfNav = frontDataService.queryCategoryById(parentId);
            // result.put("currentCategory", selfNav);
            List<CmsCategoryDTO> childCategoryList = frontDataService.categoryListByParentId(categoryId);
            result.put("childCategoryList", childCategoryList);
            return "website/category_list";
        }

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

    @GetMapping("/downloadFile/{id}.html")
    public ResponseEntity<org.springframework.core.io.Resource> download(@PathVariable("id") Long id,
            HttpServletRequest request) throws UnsupportedEncodingException {


        CmsDataDTO cmsDataDTO = frontDataService.dataDetail( id );
        String fileName = "";
        if(cmsDataDTO!=null){
            //获取这个资料的福建信息
            List<CmsDataFileEntity> dataFileList = cmsDataDTO.getDataFileList();

            if( dataFileList!=null && dataFileList.size()>0 ){
                fileName = dataFileList.get(0).getFileName();
            }
        }

        if("".equals(fileName)){
            throw new RRException("有找到指定的文件");
        }

        // Load file as Resource
        org.springframework.core.io.Resource resource = ossService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        String fileName_ = URLEncoder.encode(resource.getFilename(),"UTF-8");
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                // 下载文件能正常显示中文
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +fileName_ + "\"")
                .body(resource);
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
