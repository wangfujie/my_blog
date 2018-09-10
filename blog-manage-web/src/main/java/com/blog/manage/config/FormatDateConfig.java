package com.blog.manage.config;

import com.blog.common.utils.DateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import java.util.Date;

/**
 * @author wangfujie
 * @date 2018-08-10 17:09
 * @description 时间格式化配置
 */
@Configuration
public class FormatDateConfig {

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
