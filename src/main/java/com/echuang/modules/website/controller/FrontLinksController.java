package com.echuang.modules.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Luo.z.x
 * @Date 2020/9/15 17:47
 * @Version 1.0
 */
@Controller
@RequestMapping("/links")
public class FrontLinksController {

    @GetMapping("/list")
    public String list(){
        return "website/notice_list";
    }

}