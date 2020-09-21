package com.echuang.modules.website.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Luo.z.x
 * @Date 2020/9/15 9:50
 * @Version 1.0
 */
@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 进入首页方法
     * @return
     */
    @GetMapping(value={"/", "index"})
    public String index(){
        logger.info("enter index ...");
        // 友情链接

        // 刊物

        // 情报中心产品

        // 集团中心产品

        // 公告

        // 外购列表

        // 外文期刊

        // 中文期刊
        return "website/index";
    }








}
