package com.blog.manage.modules.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.blog.common.result.R;
import com.blog.common.utils.Md5Util;
import com.blog.common.utils.WebUtil;
import com.blog.manage.common.utils.ShiroUtils;
import com.blog.manage.modules.admin.service.IBlogAdminService;
import com.blog.pojo.entity.BlogAdmin;
import org.apache.shiro.authc.*;
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
            AuthenticationToken token = new UsernamePasswordToken(account, Md5Util.getFileMD5String(password));
            //shiro方式登录
            ShiroUtils.getSubject().login(token);
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
        String thisIp = WebUtil.getRealIpAddress(servletRequest);
//        if (!thisIp.equalsIgnoreCase(admin.getLoginIp())){
//            throw new RRException("登录ip异常，请验证手机号的登录！", 505);
//        }
        admin.setLoginIp(thisIp);
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
        //shiro方式登出
        ShiroUtils.getSubject().logout();
        return "redirect:/login.html";
    }
}