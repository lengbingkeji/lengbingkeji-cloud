package com.lengbingkeji.common.config;

import com.lengbingkeji.common.interceptors.UserInfoInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: MvcConfig
 * Package: com.lengbingkeji.common.config
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/17 15:34
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass(DispatcherServlet.class)
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器：默认拦截所有请求
        registry.addInterceptor(new UserInfoInterceptor());
    }
}
