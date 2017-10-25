package com.blog.index.modules.user.controller;

import com.blog.pojo.entity.BlogUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangfujie
 * @version 1.0.0
 * @email wangfj@chinawiserv.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        BlogUser user = new BlogUser();
        user.setName("Hello World!");
        return user.getName();
    }
}
