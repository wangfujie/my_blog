package com.blog.manage.config;

import com.blog.common.result.R;
import com.blog.common.utils.CustomException;
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

    /**
     * 统一异常处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(Exception e){
        e.printStackTrace();
        return R.error(110, e.getMessage());
    }

    /**
     * 自定义异常的处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public Object myErrorHandler(CustomException e){
        e.printStackTrace();
        return R.error(e.getCode(), e.getMsg());
    }
}
