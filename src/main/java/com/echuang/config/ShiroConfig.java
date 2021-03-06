package com.echuang.config;

import com.echuang.modules.sys.oauth2.JWTFilter;
import com.echuang.modules.sys.oauth2.OAuth2Realm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/8/26 12:34
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {

    /**
     * 通过设定Realm与系统本身的登录逻辑关联，并将登录信息放入到shiro中管理
     * @param oAuth2Realm
     * @return
     */
    @Bean("securityManager")
    public SecurityManager securityManager(OAuth2Realm oAuth2Realm){
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm( oAuth2Realm );
        securityManager.setRememberMeManager(null);
        return securityManager;
    }

    /**
     * 设定权限拦截器
     * @param securityManager
     * @return
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        //oauth过滤
        Map<String, Filter> filters = new HashMap<>();
        filters.put("oauth2", new JWTFilter());
        shiroFilter.setFilters(filters);

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/api/sys/login", "anon");
        filterMap.put("/api/sys/oss/uploadFile", "anon");
        filterMap.put("/api/sys/oss/downloadFile", "anon");
        filterMap.put("/api/sys/oss/**", "anon");
        filterMap.put("/api/sys/**", "oauth2");


        filterMap.put("/api/cms/**", "anon");
        filterMap.put("/api/wx/**", "anon");
        filterMap.put("/manage", "anon");
        filterMap.put("/**", "anon");

        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    /**
     * lifecycleBeanPostProcessor将Initializable和Destroyable的实现类统一在其内部，
     * 自动分别调用了Initializable.init()和Destroyable.destory()方法，从而达到管理shiro bean生命周期的目的
     * @return
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启注解扫码功能，开启后就能扫到类似Controller中的@RequiresPermissions("userInfo:test")这种注解
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
