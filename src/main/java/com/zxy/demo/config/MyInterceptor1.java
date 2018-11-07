package com.zxy.demo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;

@Component
public class MyInterceptor1 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        System.out.println("MyInterceptor1 action之前执行！！！");
        return true;  //继续执行action
    }

    ////该方法在action执行后，生成视图前执行。在这里，我们有机会修改视图层数据。
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1 action执行之后，生成视图之前执行！！");
    }

    //最后执行，通常用于释放资源，处理异常。我们可以根据ex是否为空，来进行相关的异常处理。
    //因为我们在平时处理异常时，都是从底层向上抛出异常，最后到了spring框架从而到了这个方法中。
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1 最后执行！！！一般用于释放资源！！");
    }

}
