package com.lengbingkeji.pay;

import com.lengbingkeji.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: PayServiceApplication
 * Package: com.lengbingkeji.pay
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 17:21
 * @Version 1.0
 */
@EnableFeignClients(
        basePackages = "com.lengbingkeji.api.feignclient",
        defaultConfiguration = DefaultFeignConfig.class
)
@MapperScan("com.lengbingkeji.pay.mapper")
@SpringBootApplication
public class PayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayServiceApplication.class, args);
    }
}
