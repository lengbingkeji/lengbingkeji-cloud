package com.lengbingkeji.api.config;

import feign.Logger;
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
}
