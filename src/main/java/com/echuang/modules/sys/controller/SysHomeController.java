package com.echuang.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SysHomeController {
    @GetMapping("/manage")
    public String home(){
        return "admin/index";
    }
}
