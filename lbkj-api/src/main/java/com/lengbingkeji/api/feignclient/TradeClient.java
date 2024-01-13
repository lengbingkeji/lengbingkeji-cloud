package com.lengbingkeji.api.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * ClassName: TradeClient
 * Package: com.lengbingkeji.api.feignclient
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 17:12
 * @Version 1.0
 */
@FeignClient("LBKJ-TRADE-SERVICE")
public interface TradeClient {
    @PutMapping("/orders/{orderId}")
    void markOrderPaySuccess(@PathVariable("orderId") Long orderId);
}
