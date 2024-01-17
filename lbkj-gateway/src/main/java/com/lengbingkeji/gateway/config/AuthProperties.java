package com.lengbingkeji.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: AuthProperties
 * Package: com.lengbingkeji.gateway.config
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/17 10:39
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "hm.auth")
public class AuthProperties {
    private List<String> includePaths;
    private List<String> excludePaths;
}
