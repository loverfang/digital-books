package com.echuang.modules.cms.controller;

import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.ResultResponse;
import com.echuang.common.web.AbstractController;
import com.echuang.modules.cms.entity.CmsLinkEntity;
import com.echuang.modules.cms.service.CmsLinkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 友情链接
 * @Author Luo.z.x
 * @Date 2020/8/28 11:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/cms/link")
public class LinkController extends AbstractController {

    @Resource
    private CmsLinkService csLinkService;

    @GetMapping("/list")
    public ResultResponse list(@RequestParam Map<String, Object> params) {
        PageUtils page = csLinkService.queryPageList( params );
        return ResultResponse.ok().put("page", page);
    }

    @PostMapping("/add")
    public ResultResponse add(@RequestBody CmsLinkEntity cmsLinkEntity){
        csLinkService.save(cmsLinkEntity);
        return ResultResponse.ok();
    }

    @PostMapping("/update")
    public ResultResponse update(@RequestBody CmsLinkEntity cmsLinkEntity){
        csLinkService.saveOrUpdate(cmsLinkEntity);
        return ResultResponse.ok();
    }

    @PostMapping("/del")
    public ResultResponse del(@RequestBody List<Long> ids){
        csLinkService.removeByIds(ids);
        return ResultResponse.ok();
    }

}
