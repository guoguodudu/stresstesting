/**
 * Copyright (C), 2018-2018, 深圳饭来科技有限公司
 * FileName: HeaderFilter
 * Author:   qingx
 * Date:     2018/5/7 19:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.stress.test.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author qingx
 * @create 2018/5/7
 * @since
 */
@Slf4j
@Order(1)
@WebFilter(filterName = "headerFilter", urlPatterns = {"/*"})
public class HeaderFilter implements Filter {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpServletRequest reqs = (HttpServletRequest) servletRequest;

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin*",reqs.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT , OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        response.setHeader("Access-Control-Expose-Headers", "*");
        filterChain.doFilter(reqs, response);

    }

    @Override
    public void destroy() {

    }
}
