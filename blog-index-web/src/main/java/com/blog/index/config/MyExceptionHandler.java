package com.blog.index.config;

import com.blog.common.result.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangfujie
 * @date 2018-12-12 16:45
 * @description 全局异常捕获处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(Exception e){
        e.printStackTrace();
        return R.error(100, e.getMessage());
    }
}
