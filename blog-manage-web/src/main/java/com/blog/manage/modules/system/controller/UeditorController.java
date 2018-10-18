package com.blog.manage.modules.system.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author wangfujie
 * @date 2018-10-18 15:00
 * @description 用于处理关于ueditor插件相关的请求
 */
@RestController
@CrossOrigin
@RequestMapping("/sys/ueditor")
public class UeditorController {

    @RequestMapping(value = "/exec")
    public String exec(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String rootPath = request.getRealPath("/");
        return new ActionEnter( request, rootPath).exec();
    }

}