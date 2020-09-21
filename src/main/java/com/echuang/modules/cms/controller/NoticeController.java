package com.echuang.modules.cms.controller;

import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.ResultResponse;
import com.echuang.modules.cms.entity.CmsNoticeEntity;
import com.echuang.modules.cms.service.CmsLinkService;
import com.echuang.modules.cms.service.CmsNoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 通知公告
 * @Author Luo.z.x
 * @Date 2020/8/28 11:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/cms/notice")
public class NoticeController {

    @Resource
    private CmsNoticeService cmsNoticeService;

    @GetMapping("/list")
    public ResultResponse list(@RequestParam Map<String, Object> params) {
        PageUtils page = cmsNoticeService.queryPageList( params );
        return ResultResponse.ok().put("page", page);
    }
    @PostMapping("/add")
    public ResultResponse add(@RequestBody CmsNoticeEntity cmsNotice){
        cmsNoticeService.saveCmsNotice(cmsNotice);
        return ResultResponse.ok();
    }
    @PostMapping("/update")
    public ResultResponse update(@RequestBody CmsNoticeEntity cmsNotice){
        cmsNoticeService.updateCmsNotice(cmsNotice);
        return ResultResponse.ok();
    }
    @PostMapping("/del")
    public ResultResponse del(@RequestBody List<Long> ids){
        cmsNoticeService.deleteCmsNotice(ids);
        return ResultResponse.ok();
    }
}
