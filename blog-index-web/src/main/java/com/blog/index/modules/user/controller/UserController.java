package com.blog.index.modules.user.controller;

import com.blog.index.modules.user.service.IBlogUserService;
import com.blog.pojo.entity.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangfujie
 * @date 2018-08-09 15:32
 * @description 用户相关，控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IBlogUserService blogUserService;

    @GetMapping("/getBlogUserList")
    public Object getBlogUserList(){
        return blogUserService.getBlogUserList();
    }

    @GetMapping("/hello")
    public String hello(){
        BlogUser user = new BlogUser();
        user.setName("Hello World!");
        return user.getName();
    }
}
