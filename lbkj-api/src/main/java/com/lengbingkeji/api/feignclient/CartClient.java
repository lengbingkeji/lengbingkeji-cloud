package com.lengbingkeji.api.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: CartClient
 * Package: com.lengbingkeji.api.feignclient
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 16:32
 * @Version 1.0
 */
@FeignClient("LBKJ-CART-SERVICE")
public interface CartClient {
    @DeleteMapping("/carts")
    void deleteCartItemByIds(@RequestParam("ids") Collection<Long> ids);
}
