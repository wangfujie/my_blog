package com.blog.manage.modules.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.blog.common.result.R;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.manage.common.utils.ShiroUtils;
import com.blog.manage.modules.admin.service.IBlogAdminService;
import com.blog.pojo.entity.BlogAdmin;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author wangfujie
 * @date 2018-08-13 15:56
 * @description 登录接口
 */
@RestController
@RequestMapping("/sys")
public class LoginController {

    @Autowired
    private IBlogAdminService adminService;

    @PostMapping(value = "/login")
    public R login(String account, String password, HttpSession httpSession, HttpServletRequest servletRequest){
        BlogAdmin admin = adminService.selectOne(new EntityWrapper<BlogAdmin>().eq("account",account));
        //不存在用户或者密码不正确
        if (admin == null || !password.equals(admin.getPassword())) {
            return R.error(MessageSourceUtil.getMessage("20001"));
        }else {
            //删除的账号
            if (admin.getStatus() == 0){
                return R.error(MessageSourceUtil.getMessage("20004"));
            }
            admin.setLoginIp(ShiroUtils.getClientIP(servletRequest));
            admin.setLoginTime(new Date());
            adminService.updateById(admin);
        }
        Subject subject = ShiroUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(account, password);
        //shiro方式登录
        subject.login(token);
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