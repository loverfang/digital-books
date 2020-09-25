package com.echuang.modules.cms.websitecontroller;

import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsNoticeDTO;
import com.echuang.modules.cms.service.FrontConfigService;
import com.echuang.modules.cms.service.FrontNoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/9/15 17:47
 * @Version 1.0
 */
@Controller
@RequestMapping("/notice")
public class FrontNoticeController {

    @Resource
    FrontNoticeService frontNoticeService;
    @Resource
    FrontConfigService frontConfigService;

    @GetMapping("/list")
    public String list(HttpServletRequest request,
                       @RequestParam(value = "pageNo", required = false) Integer pageNo,
                       @RequestParam(value = "pageSize", required = false) Integer pageSize){
        // 内容分页列表
        Integer page = pageNo==null?1:pageNo;
        Integer limit = pageSize==null?frontConfigService.getConfigObject("pageSize",Integer.class):pageSize;

        Map<String, Object> result = new HashMap<>();
        PageUtils resultPage =  frontNoticeService.noticeList(page, limit);
        result.put("page", resultPage);
        result.put("navId",-1);

        request.setAttribute("root", result);
        return "website/notice_list";
    }

    @GetMapping(value={"/detail/{id}.html"} )
    public String detail(HttpServletRequest request, @PathVariable("id") Long id) {
        CmsNoticeDTO cmsNoticeDTO = frontNoticeService.noticeDetail(id);
        Map<String,Object> result = new HashMap<>();
        result.put("noticeInfo",cmsNoticeDTO);
        result.put("navId",-1);
        request.setAttribute("root", result);
        return "website/notice_detail";
    }

}