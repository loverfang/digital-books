package com.echuang.modules.sys;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("mytest")
    public String mytest(){
        return "hello";
    }
}
