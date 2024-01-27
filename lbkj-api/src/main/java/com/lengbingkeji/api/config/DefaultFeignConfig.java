package com.lengbingkeji.api.config;

import com.lengbingkeji.api.feignclient.fallback.ItemClientFallback;
import com.lengbingkeji.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

/**
 * ClassName: DefaultFeignConfig
 * Package: com.lengbingkeji.api.config
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 11:06
 * @Version 1.0
 */
public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    //通过匿名内部类声明拦截器
    @Bean
    public RequestInterceptor userInfoRequestInterceptor(){
        return new RequestInterceptor(){
            @Override
            public void apply(RequestTemplate requestTemplate) {
                Long userId = UserContext.getUser();
                if(userId != null){
                    requestTemplate.header("user-info", userId.toString());
                }
            }
        };
    }

    //降级处理类ItemClientFallback
    @Bean
    public ItemClientFallback itemClientFallback(){
        return new ItemClientFallback();
    }
}
