package com.echuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description 数字图书管启动类
 * @Author Luo.z.x
 * @Date 2020/8/26 18:32
 * @Version 1.0
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableCaching
public class BootApplication{
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
