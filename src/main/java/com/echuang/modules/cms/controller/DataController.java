package com.echuang.modules.cms.controller;

import com.echuang.common.exception.RRException;
import com.echuang.common.utils.ResultResponse;
import com.echuang.modules.cms.entity.CmsDataEntity;
import com.echuang.modules.cms.service.CmsDataService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 杂志管理
 * @Author Luo.z.x
 * @Date 2020/8/28 11:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/cms/data")
public class DataController {
    @Resource
    private CmsDataService cmsDataService;

    /**
     * 分页数据列表
     * @param params
     * @return
     */
    @GetMapping("/list")
    public ResultResponse list(@RequestParam Map<String, Object> params) {
        Integer page = params.get("page") == null? (Integer)params.get("page") : 1;
        Integer limit = params.get("limit") == null? (Integer)params.get("limit") : 1;

        cmsDataService.queryPageList(params, page, limit);
        return ResultResponse.ok().put("page", page);
    }

    /**
     * 添加资料
     * @param cmsData
     * @return
     */
    @PostMapping("/add")
    public ResultResponse add(@RequestBody CmsDataEntity cmsData){
        cmsDataService.saveCmsData(cmsData);
        return ResultResponse.ok();
    }

    /**
     * 更新资料
     * @param cmsData
     * @return
     */
    @PostMapping("/update")
    public ResultResponse update(@RequestBody CmsDataEntity cmsData){
        cmsDataService.saveOrUpdateCmsData( cmsData );
        return ResultResponse.ok();
    }

    /**
     * 资料详情
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public ResultResponse detail(Long id){
        cmsDataService.getCmsDataById(id);
        return ResultResponse.ok();
    }

    /**
     * 删除资料实则修改状态为0，即不可见
     * @param ids
     * @return
     */
    @PostMapping("/del")
    public ResultResponse del(@RequestBody List<Long> ids){

        if(CollectionUtils.isEmpty(ids)){
            throw new RRException("删除id列表为空!");
        }

        Map<String,Object> param = new HashMap<>();
        param.put("status", 0);
        param.put("ids",ids);
        cmsDataService.updateStatusBatchByMap(param);
        return ResultResponse.ok();
    }
}
