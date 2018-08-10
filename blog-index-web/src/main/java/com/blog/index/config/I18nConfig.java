package com.blog.index.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangfujie
 * @date 2018-08-10 10:34
 * @description i18n国际化配置
 */
@Component
@ConfigurationProperties(prefix = "spring.messages")
public class I18nConfig {
    private String basename;
    private Integer cacheSeconds;

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }

    public Integer getCacheSeconds() {
        return cacheSeconds;
    }

    public void setCacheSeconds(Integer cacheSeconds) {
        this.cacheSeconds = cacheSeconds;
    }
}