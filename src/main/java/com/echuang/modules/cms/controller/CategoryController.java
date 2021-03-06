package com.echuang.modules.cms.controller;

import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.ResultResponse;
import com.echuang.common.utils.SnowflakeIdWorker;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import com.echuang.modules.cms.service.CmsCategoryService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description 杂志类别管理
 * @Author Luo.z.x
 * @Date 2020/8/28 11:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/cms/category")
public class CategoryController {

    @Resource
    private CmsCategoryService cmsCategoryService;

    /**
     * 类别第一层分页查询
     * @param params
     * @return
     */
    @GetMapping("/list")
    public ResultResponse list(@RequestParam Map<String, Object> params) {
        Integer pageNo = params.get("page")==null?1:Integer.valueOf((String)params.get("page"));
        Integer limit = params.get("limit")==null?10:Integer.valueOf((String)params.get("limit"));

        PageUtils page = cmsCategoryService.queryPageByParent(params ,pageNo, limit);
        return ResultResponse.ok().put("page", page);
    }

    @GetMapping("/childList")
    public ResultResponse childList(Long parentId) {
        List<Map<String, Object>> childList = cmsCategoryService.childList(parentId);
        return ResultResponse.ok().put("page", childList);
    }

    @GetMapping("/treeList")
    public ResultResponse treeList(){
        List<CmsCategoryEntity> treeList = cmsCategoryService.treeList();
        return ResultResponse.ok().put("treeList", treeList);
    }

    @GetMapping("/detail")
    public ResultResponse detail(Long categoryId){
        return ResultResponse.ok().put("category",cmsCategoryService.detail(categoryId));
    }

    @PostMapping("/add")
    public ResultResponse add(@RequestBody CmsCategoryEntity cmsCategory){
        cmsCategory.setCategoryId(SnowflakeIdWorker.getSnowflakeId());
        cmsCategory.setStatus( 1 );
        cmsCategory.setIsDefault( 0 );
        cmsCategoryService.add(cmsCategory);
        return ResultResponse.ok();
    }

    @PostMapping("/update")
    public ResultResponse update(@RequestBody CmsCategoryEntity cmsCategory){
        cmsCategoryService.update(cmsCategory);
        return ResultResponse.ok();
    }

    @PostMapping("/delete")
    public ResultResponse delete(@RequestBody List<Long> categoryIds){
        Integer status = 0;
        int updateResult = cmsCategoryService.updateStatus( categoryIds.get(0), status);
        if(updateResult == -1){
            return ResultResponse.error("系统菜单无法删除！");
        }
        if(updateResult ==0){
          return ResultResponse.error("该类型下有子类型，请先删除子类型再进行操作！");
        }
        return ResultResponse.ok();
    }

    @PostMapping("/resume")
    public ResultResponse resume(@RequestBody List<Long> modelIds){
        Integer status = 1;
        cmsCategoryService.batchUpdateStatus( modelIds, status);
        return ResultResponse.ok();
    }
}
