package com.blog.manage.config;

import com.blog.manage.common.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wangfujie
 * @date 2018-09-10 16:04
 * @description session-shiro过滤等配置
 */
@Configuration
public class SessionShiroConfig {

    @Bean(name = "sessionManager")
    public SessionManager sessionManager() {
        return new ServletContainerSessionManager();
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean(name = "securityManager")
    public SecurityManager securityManager(SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
//        shiroFilter.setLoginUrl("/"+projectName);
        shiroFilter.setLoginUrl("/");
        shiroFilter.setSuccessUrl("/index.html");
        shiroFilter.setUnauthorizedUrl("/");

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/public/**", "anon");
        filterMap.put("/common/**", "anon");
        filterMap.put("/sys/**", "anon");
        //swagger配置
        filterMap.put("/swagger**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-resources/configuration/ui", "anon");

        //文件上传下载
        filterMap.put("/testupload.html", "anon");
        filterMap.put("/sys/oss/upload*", "anon");
        filterMap.put("/sys/oss/download1/*", "anon");

        filterMap.put("/captcha.jpg", "anon");
        filterMap.put("/getInfoOnLoginPage", "anon");
        filterMap.put("/error/**", "anon");
        filterMap.put("/**/*.html", "anon");
        filterMap.put("/**/*.js", "anon");
        filterMap.put("/**/*.css", "anon");
        filterMap.put("/**/*.woff", "anon");
        filterMap.put("/**/*.png", "anon");
        filterMap.put("/common/validateCode/validate/**", "anon");
        filterMap.put("/common/email/**", "anon");
        filterMap.put("/common/smsCode/**", "anon");
        //系统同步接口放行
        filterMap.put("/system/dept/provideData", "anon");
        filterMap.put("/system/user/provideData", "anon");
        filterMap.put("/system/region/provideData", "anon");
        filterMap.put("/sysDict/provideData", "anon");
        filterMap.put("/system/productIntegrate/postData", "anon");
        //lic放行的请求。
        filterMap.put("/lic/licErrorPage", "anon");
        filterMap.put("/lic/uploadLic", "anon");
        //单点登录url
        filterMap.put("/ssologin/**", "anon");

        filterMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);

        return shiroFilter;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
