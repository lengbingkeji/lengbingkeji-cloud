package com.lengbingkeji.user;

import com.lengbingkeji.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: UserServiceApplication
 * Package: com.lengbingkeji.user
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 12:04
 * @Version 1.0
 */
@EnableFeignClients(
        basePackages = "com.lengbingkeji.api.feignclient",
        defaultConfiguration = DefaultFeignConfig.class
)
@MapperScan("com.lengbingkeji.user.mapper")
@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
