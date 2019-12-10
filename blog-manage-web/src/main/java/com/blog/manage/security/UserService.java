package com.blog.manage.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.blog.manage.modules.admin.service.IBlogAdminService;
import com.blog.pojo.entity.BlogAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

/**
 * description
 *
 * @author wangfujie
 * @version v1.0.0
 * @create 2019年10月23日
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IBlogAdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BlogAdmin blogAdmin = adminService.selectOne(new EntityWrapper<BlogAdmin>().eq("account", username));

        if (blogAdmin == null){
            throw new UsernameNotFoundException("找不到该用户！");
        }

        if (blogAdmin.getStatus() == 0){
            throw new RuntimeException("用户没有权限！");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
//        if (blogAdmin.getStatus() == 0){
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        }else {
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }
        Admin admin = new Admin();
        admin.setId(blogAdmin.getId());
        admin.setUsername(blogAdmin.getAccount());
        admin.setPassword(blogAdmin.getPassword());
        admin.setPermissions(authorities);
        return admin;
    }
}
