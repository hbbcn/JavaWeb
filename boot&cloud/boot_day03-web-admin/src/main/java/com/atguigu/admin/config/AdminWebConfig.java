package com.atguigu.admin.config;

import com.atguigu.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *@ClassName AdminWebConfig
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/3 21:09
 *@Version 1.0
 */

/**
 * 如何使用拦截器
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptor）
 * 3、指定拦截规则【如果拦截所有静态资源也会被拦截】
 */
//@EnableWebMvc + WebMvcConfigurer - @Bean 可以全面接管SpringMVC,所有规则全部自己重新配置；实现定制和扩展功能
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
            .addPathPatterns("/**") //所有请求都会被拦截，包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**,","/sql","/redisTest"); //放行请求
}
}

