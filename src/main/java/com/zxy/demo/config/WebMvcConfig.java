package com.zxy.demo.config;

import com.zxy.demo.filter.MyFilter1;
import com.zxy.demo.filter.MyFilter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor1 myInterceptor1;
    @Autowired
    private MyInterceptor2 myInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> includePathPatterns = new ArrayList();
        List<String> excludePathPatterns = new ArrayList();
        includePathPatterns.add("/user/*");
        //excludePathPatterns.add("/user/getUserListByPager");

        registry.addInterceptor(myInterceptor1).addPathPatterns(includePathPatterns).excludePathPatterns(excludePathPatterns);
        registry.addInterceptor(myInterceptor2).addPathPatterns(includePathPatterns).excludePathPatterns(excludePathPatterns);
    }

    @Bean
    public FilterRegistrationBean setMyFilter2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter2());
        registration.addUrlPatterns("/*");
        registration.setName("setMyFilter2");
        registration.addInitParameter("charset","utf-8");
        registration.setOrder(2);
        return registration;
    }

    @Bean
    public FilterRegistrationBean setMyFilter1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter1());
        registration.addUrlPatterns("/*");
        registration.setName("setMyFilter1");
        registration.addInitParameter("charset","utf-8");
        registration.setOrder(2);
        return registration;
    }


}
