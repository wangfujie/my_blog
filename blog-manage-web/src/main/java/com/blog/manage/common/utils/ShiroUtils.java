package com.blog.manage.common.utils;

import com.blog.common.utils.CustomException;
import com.blog.pojo.entity.BlogAdmin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wangfujie
 * @date 2018-08-13 16:19
 * @description shiro工具类
 */
public class ShiroUtils {

    /**
     * 获取Session
     * @return
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取Subject
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取登录用户信息
     * @return
     */
    public static BlogAdmin getUserEntity() {
        return (BlogAdmin) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取登录用户主键id
     * @return
     */
    public static Integer getAdminId() {
        return getUserEntity().getId();
    }

    /**
     * 存值到session
     * @param key
     * @param value
     */
    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 通过key从session中取出内容
     * @param key
     * @return
     */
    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    /**
     * 判断是否登录
     * @return
     */
    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    /**
     * 登出
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 获取验证码
     * @param key
     * @param httpSession
     * @return
     */
    public static String getKaptcha(String key, HttpSession httpSession) {
        Object kaptcha = httpSession.getAttribute(key);
        if (kaptcha == null) {
            throw new CustomException("验证码已失效");
        }
        return kaptcha.toString();
    }
}