package com.lengbingkeji.cart;

import com.lengbingkeji.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: CartServiceApplication
 * Package: com.lengbingkeji.cart
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 16:43
 * @Version 1.0
 */
//@EnableFeignClients(basePackages = "com.lengbingkeji.api.feignclient")
@EnableFeignClients(
        basePackages = "com.lengbingkeji.api.feignclient",
        defaultConfiguration = DefaultFeignConfig.class
)
@MapperScan("com.lengbingkeji.cart.mapper")
@SpringBootApplication
public class CartServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartServiceApplication.class, args);
    }

    //网络请求：第一步
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
