package com.blog.index.utils;

import com.blog.common.utils.CustomException;
import com.blog.pojo.entity.BlogUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import javax.servlet.http.HttpSession;

/**
 * @author wangfujie
 * @date 2018-08-13 16:19
 * @description shiro工具类
 */
public class ShiroUtils {
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static BlogUser getUserEntity() {
        return (BlogUser) SecurityUtils.getSubject().getPrincipal();
    }

    public static String getUserId() {
        return getUserEntity().getUuid();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

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