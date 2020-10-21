package com.atguigu.springboot.filter;

import jdk.internal.dynalink.ChainedCallSite;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("myFilter process....");
        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
