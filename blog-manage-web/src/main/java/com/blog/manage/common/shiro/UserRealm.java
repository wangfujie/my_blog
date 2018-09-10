package com.blog.manage.common.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.blog.manage.modules.admin.service.IBlogAdminService;
import com.blog.pojo.entity.BlogAdmin;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangfujie
 * @date 2018-09-10 17:20
 * @description shiro认证
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IBlogAdminService adminService;

    /**
     * 授权(验证权限时调用)
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证(登录时调用)
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        //查询用户信息
        BlogAdmin user =  adminService.selectOne(new EntityWrapper<BlogAdmin>().eq("account",account));
        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        //密码错误
        if(!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        //账号禁用
        if(user.getStatus() == 0){
            throw new LockedAccountException("账号已被禁用,请联系管理员");
        }
        //设置用户信息
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
