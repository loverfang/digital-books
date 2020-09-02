package com.echuang.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 生成验证码配置
 * @Author Luo.z.x
 * @Date 2020/8/26 12:34
 * @Version 1.0
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        // 设置边框
        properties.setProperty("kaptcha.border", "no");
        // 设置边框颜色
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // 设置字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        // 设置图片宽度
        properties.setProperty("kaptcha.image.width", "118");
        // 设置图片高度
        properties.setProperty("kaptcha.image.height", "36");
        // 设置字体尺寸
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        // 设置验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        // 设置字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,黑体");

        //        properties.setProperty("kaptcha.border", "no");
//        properties.setProperty("kaptcha.textproducer.font.size", "28");
//        properties.setProperty("kaptcha.image.width", "99");
//        properties.setProperty("kaptcha.image.height", "38");
//        properties.setProperty("kaptcha.textproducer.char.length", "4");
//        properties.setProperty("kaptcha.textproducer.font.names",  "Arial");
//        properties.setProperty("kaptcha.noise.impl","com.google.code.kaptcha.impl.NoNoise");
//        properties.setProperty("kaptcha.textproducer.char.space","2");

        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
