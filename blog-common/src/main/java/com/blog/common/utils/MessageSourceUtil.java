package com.blog.common.utils;

import com.blog.common.language.BaseLang;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author wangfujie
 * @date 2018-08-10 9:46
 * @description 获取国际化文件中的内容
 */
public class MessageSourceUtil {
    private static ResourceBundleMessageSource messageSource ;

    private static void init(){
        if(messageSource == null) {
            messageSource = new ResourceBundleMessageSource();
            messageSource.setBasename("i18n/messages");
        }
    }

    public static String getMessage(String code){
        init();
        return messageSource.getMessage(code, null, BaseLang.getDefault());
    }
}