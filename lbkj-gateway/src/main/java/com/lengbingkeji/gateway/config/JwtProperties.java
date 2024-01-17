package com.lengbingkeji.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * ClassName: JwtProperties
 * Package: com.lengbingkeji.gateway.config
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/17 10:40
 * @Version 1.0
 */
@Data
//@Component
@ConfigurationProperties(prefix = "hm.jwt")
public class JwtProperties {
    private Resource location;
    private String password;
    private String alias;
    private Duration tokenTTL = Duration.ofMinutes(10);
}
