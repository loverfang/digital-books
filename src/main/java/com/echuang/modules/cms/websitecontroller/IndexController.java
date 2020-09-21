package com.echuang.modules.cms.websitecontroller;

import com.echuang.common.utils.PageUtils;
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

import javax.annotation.Resource;
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
    public String index(){
        Map<String,Object> dataMap = new HashMap<>();
        logger.info("enter index ...");

        // 情报中心产品
        // 集团中心产品
        // 刊物
        // 外购列表

        // 外文期刊
        // 中文期刊
        // 友情链接
        dataMap.put("linkList", linkIndexList());
        // 公告
        dataMap.put("noticeList", noticeIndexList());
        return "website/index";
    }

    /**
     * 通用查询方法
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(String keyword){
        return "website/search_result";
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
