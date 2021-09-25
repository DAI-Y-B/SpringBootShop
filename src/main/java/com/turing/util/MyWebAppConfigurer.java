package com.turing.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    /**
     * 资源映射路径，上传图片之后要配置图片路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**").addResourceLocations("file:D:/upload/");
    }

    /**
     * 编写拦截器
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //对于登录拦截的设置
//        InterceptorRegistration registration1 = registry.addInterceptor(new LoginInterceptor());
//        //拦截请求
//        registration1.addPathPatterns("/**");
//        //指定不拦截的请求(登录不拦截)
//        registration1.excludePathPatterns("/user/login");
//        //对于其他拦截的设置
//        InterceptorRegistration registration2 = registry.addInterceptor(new OtherInterceptor());
//        //拦截请求
//        registration2.addPathPatterns("/**");
//
//    }
}