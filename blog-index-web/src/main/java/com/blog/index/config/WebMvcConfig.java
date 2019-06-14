package com.blog.index.config;

import com.blog.common.utils.DateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import java.util.Date;

/**
 * @author wangfujie
 * @date 2018-08-10 17:09
 * @description webMvc的配置
 */
@Configuration
@Profile({"pro"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Bean
    public ProtectCommitInterceptor protectCommitInterceptor() {
        return new ProtectCommitInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置提交拦截器
        registry.addInterceptor(protectCommitInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(localeChangeInterceptor());
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
                    //去除前后空格
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
}
