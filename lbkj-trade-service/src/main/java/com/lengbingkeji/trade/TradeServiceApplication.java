package com.lengbingkeji.trade;

import com.lengbingkeji.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: TradeServiceApplication
 * Package: com.lengbingkeji.trade
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 15:47
 * @Version 1.0
 */
@EnableFeignClients(
        basePackages = "com.lengbingkeji.api.feignclient",
        defaultConfiguration = DefaultFeignConfig.class
)
@MapperScan("com.lengbingkeji.trade.mapper")
@SpringBootApplication
public class TradeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradeServiceApplication.class, args);
    }
}
