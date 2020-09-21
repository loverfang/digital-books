package com.echuang.modules.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class FrontProductController {

    @GetMapping("/list")
    public String list(@RequestParam(required = false) Long parentId, @RequestParam(required = false) Long categoryid){
        // 同级别列表
        // 当前类别下的文件列表
        return "website/product_list";
    }

    @GetMapping("/detail")
    public String detail(Long id){
        return "website/product_detail";
    }

}
