package com.zxy.demo.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter2 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter2 start");

        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("MyFilter2 finish");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter2 destroy");
    }
}
