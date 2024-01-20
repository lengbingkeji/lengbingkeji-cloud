package com.lengbingkeji.cart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: CartProperties
 * Package: com.lengbingkeji.cart.config
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/20 18:55
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "lbkj.cart")
public class CartProperties {
    private Integer maxAmount;
}
