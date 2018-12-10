package com.blog.index.modules.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.blog.common.result.R;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.index.modules.user.service.IBlogUserService;
import com.blog.index.utils.ShiroUtils;
import com.blog.pojo.entity.BlogUser;
import com.google.code.kaptcha.Constants;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wangfujie
 * @date 2018-08-13 15:56
 * @description 登录接口
 */
@RestController
@RequestMapping("/sys")
public class LoginController {
    @Autowired
    private IBlogUserService blogUserService;

    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpSession httpSession, HttpServletRequest servletRequest){
        //获取验证码
        String code = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY, httpSession);
        if (!captcha.equalsIgnoreCase(code)) {
            return R.error(MessageSourceUtil.getMessage("20002"));
        }
        BlogUser blogUser = blogUserService.selectOne(new EntityWrapper<BlogUser>().eq("account",username));
        //不存在用户或者密码不正确
        if (blogUser == null || !password.equals(blogUser.getPassword())) {
            return R.error(MessageSourceUtil.getMessage("20001"));
        }
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