package com.blog.manage.common.utils;

import com.blog.manage.security.Admin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 登录用户获取工具类
 *
 * @author wangfujie
 * @version v1.0.0
 * @create 2019年10月17日
 */
public class SecurityUtils {

    /**
     * 获得登录用户对象
     * @return
     */
    public static Admin getLoginAdmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication == null ? null : (Admin) authentication.getPrincipal();
    }

    /**
     * 获取登录用户id
     * @return
     */
    public static int getLoginAdminId(){
        Admin admin = getLoginAdmin();
        return admin == null ? 0 : admin.getId();
    }
}
