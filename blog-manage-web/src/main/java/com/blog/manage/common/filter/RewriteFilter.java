package com.blog.manage.common.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Set;

/**
 * @author wangfujie
 * @date 2018-09-10 18:00
 * @description 重写过滤器
 */
public class RewriteFilter implements Filter {

    /**
     * 需要rewrite到的目的地址
     */
    public static final String REWRITE_TO = "rewriteUrl";
    /**
     * 拦截的url,url通配符之前用英文分号隔开
     */
    public static final String REWRITE_PATTERNS = "urlPatterns";
    /**
     * 配置url通配符
     */
    private Set<String> urlPatterns = null;
    private String rewriteTo = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化拦截配置

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
