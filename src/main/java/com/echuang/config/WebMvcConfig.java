package com.echuang.config;

import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.echuang.common.interceptor.BasePathInterceptor;
import com.echuang.common.interceptor.NavigaterInterceptor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;

/**
 * @Author Luo.z.x
 * @Date 2020/8/28 15:07
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${uploadFile.resourceHandler}")
    private String resourceHandler;

    @Value("${uploadFile.location}")
    private String location;

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setCache(false);
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".html");
//        resolver.setContentType("text/html; charset=UTF-8");
//        registry.viewResolver(resolver);
//    }

    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(true).maxAge(3600);
    }

    /**
     * 虚拟映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 就是说 url （http://localhost:8080/flow/upload_flowChart/xxxxxxx.jpg）
        // 中出现 resourceHandler 匹配时，则映射到 location 中去,location 相当于虚拟的，被映射的路径
        // 映射本地文件时，开头必须是 file:/// 开头，表示协议
        registry.addResourceHandler(resourceHandler).addResourceLocations("file:///" + location);
        registry.addResourceHandler(new String[] { "/res/**" }).addResourceLocations(new String[] { "classpath:/static/" });
    }

    /**
     * 载入自定义拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(basePathInterceptor()).addPathPatterns(new String[] { "/**" });
        registry.addInterceptor(navigaterInterceptor())
                .addPathPatterns(new String[] {"/","/index","/product/**","*.html"})
                .excludePathPatterns("/sys/**","/wx/**","/cms/**");
    }

    @Bean
    public BasePathInterceptor basePathInterceptor() {
        return new BasePathInterceptor();
    }
    @Bean
    public NavigaterInterceptor navigaterInterceptor() {
        return new NavigaterInterceptor();
    }
}
