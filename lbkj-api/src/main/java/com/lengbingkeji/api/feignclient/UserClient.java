package com.lengbingkeji.api.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: UserClient
 * Package: com.lengbingkeji.api.feignclient
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 17:04
 * @Version 1.0
 */
@FeignClient("LBKJ-USER-SERVICE")
public interface UserClient {
    @PutMapping("/users/money/deduct")
    void deductMoney(@RequestParam("pw") String pw, @RequestParam("amount") Integer amount);
}
