package com.blog.manage.modules.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.blog.common.result.R;
import com.blog.manage.common.utils.ShiroUtils;
import com.blog.manage.modules.admin.service.IBlogAdminService;
import com.blog.pojo.entity.BlogAdmin;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author wangfujie
 * @date 2018-08-13 15:56
 * @description 登录接口
 */
@Controller
@RequestMapping("/sys")
public class LoginController {

    @Autowired
    private IBlogAdminService adminService;

    @PostMapping(value = "/login")
    @ResponseBody
    public R login(String account, String password, HttpServletRequest servletRequest){
        BlogAdmin admin = adminService.selectOne(new EntityWrapper<BlogAdmin>().eq("account",account));
        try {
            Subject subject = ShiroUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(account, password);
            //shiro方式登录
            subject.login(token);
        }catch (UnknownAccountException e){
            //账号存在
            return R.error(e.getMessage());
        }catch (IncorrectCredentialsException e){
            //密码不正确
            return R.error(e.getMessage());
        }catch (LockedAccountException e){
            //账号没登录权限
            return R.error(e.getMessage());
        }
        admin.setLoginIp(ShiroUtils.getClientIP(servletRequest));
        admin.setLoginTime(new Date());
        adminService.updateById(admin);
        return R.ok("登录成功！");
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        return "redirect:/login.html";
    }
}