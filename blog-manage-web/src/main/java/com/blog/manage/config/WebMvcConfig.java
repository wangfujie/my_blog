package com.blog.manage.config;

import com.blog.common.utils.DateUtils;
import com.blog.manage.common.filter.RewriteFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.Date;

/**
 * @author wangfujie
 * @date 2018-09-10 17:52
 * @description MVC配置
 * 继承WebMvcConfigurerAdapter覆写里面的方法修改web容器默认配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注册rewrite过滤器
        registration.setFilter(new RewriteFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter(RewriteFilter.REWRITE_TO,"/login.html");
        registration.addInitParameter(RewriteFilter.REWRITE_PATTERNS, "/");
        registration.setName("rewriteFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 处理时间格式数据转换（将前端传入的时间字符串转换为date类型）
     */
    @Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                //如果从浏览器传入字符串不等于空开始转换
                if (source != null) {
                    //去除前后的空格
                    source = source.trim();
                    if (source.equals("")) {
                        source = null;
                    }
                    //去除空格后不为空则开始转换
                    if (source != null) {
                        return DateUtils.parse(source);
                    }
                }
                return null;
            }
        };
    }

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadPath}")
    private String uploadPath;

    /**
     * 增加自定义静态文件本地映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath + "**").addResourceLocations("file:" +uploadPath );
    }
}
