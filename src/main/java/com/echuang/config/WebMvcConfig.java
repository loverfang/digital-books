package com.echuang.config;

import com.echuang.common.interceptor.BasePathInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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

    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setCache(false);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        resolver.setContentType("text/html; charset=UTF-8");
        registry.viewResolver(resolver);
    }

    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(true)
                .maxAge(3600);
    }

    /**
     * 虚拟映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 就是说 url （http://localhost:8080/flow/upload_flowChart/xxxxxxx.jpg）
        //中出现 resourceHandler 匹配时，则映射到 location 中去,location 相当于虚拟的，被映射的路径
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
    }

    @Bean
    public BasePathInterceptor basePathInterceptor() {
        return new BasePathInterceptor();
    }
}
