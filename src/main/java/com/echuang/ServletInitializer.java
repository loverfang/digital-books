package com.echuang;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *  数字图书管Web启动类
 *  @Author Luo.z.x
 *  @Date 2020/8/26 18:32
 *  @Version 1.0
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootApplication.class);
    }
}
