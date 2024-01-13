package com.lengbingkeji.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import java.time.Duration;

/**
 * ClassName: JwtProperties
 * Package: com.lengbingkeji.user.config
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 12:11
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "hm.jwt")
public class JwtProperties {
    private Resource location;
    private String password;
    private String alias;
    private Duration tokenTTL = Duration.ofMinutes(10);
}

