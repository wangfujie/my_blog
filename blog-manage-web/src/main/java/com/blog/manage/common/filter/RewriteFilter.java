package com.blog.manage.common.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

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
        rewriteTo = filterConfig.getInitParameter(REWRITE_TO);
        String exceptUrlString = filterConfig.getInitParameter(REWRITE_PATTERNS);
        if (!StringUtils.isEmpty(exceptUrlString)) {
            urlPatterns = Collections.unmodifiableSet(
                    new HashSet<>(Arrays.asList(exceptUrlString.split(";", 0))));
        } else {
            urlPatterns = Collections.emptySet();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String servletPath = request.getServletPath();
        String context = request.getContextPath();
        //匹配的路径重写
        if (isMatches(urlPatterns, servletPath)) {
            servletRequest.getRequestDispatcher(context+"/"+rewriteTo).forward(servletRequest, servletResponse);
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 匹配返回true，不匹配返回false
     * @param patterns 正则表达式或通配符
     * @param url 请求的url
     * @return
     */
    private boolean isMatches(Set<String> patterns, String url) {
        if(null == patterns){
            return false;
        }
        for (String str : patterns) {
            if (str.endsWith("/*")) {
                String name = str.substring(0, str.length() - 2);
                if (url.contains(name)) {
                    return true;
                }
            } else {
                Pattern pattern = Pattern.compile(str);
                if (pattern.matcher(url).matches()) {
                    return true;
                }
            }
        }
        return false;
    }
}
