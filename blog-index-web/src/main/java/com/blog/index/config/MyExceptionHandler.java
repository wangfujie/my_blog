package com.blog.index.config;

import com.blog.common.result.R;
import com.blog.common.utils.RRException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangfujie
 * @date 2018-12-12 16:45
 * @description 自定义异常的统一返回处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = RRException.class)
    @ResponseBody
    public Object errorHandler(RRException e){
        e.printStackTrace();
        return R.error(e.getCode(), e.getMessage());
    }
}
