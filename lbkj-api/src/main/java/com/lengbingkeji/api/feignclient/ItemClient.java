package com.lengbingkeji.api.feignclient;

import com.lengbingkeji.api.config.DefaultFeignConfig;
import com.lengbingkeji.api.dto.ItemDTO;
import com.lengbingkeji.api.dto.OrderDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: ItemClient
 * Package: com.lengbingkeji.api.feignclient
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 10:20
 * @Version 1.0
 */
@FeignClient("LBKJ-ITEM-SERVICE")
//@FeignClient(value = "LBKJ-ITEM-SERVICE", configuration = DefaultFeignConfig.class)
public interface ItemClient {
    @GetMapping("/items")
    List<ItemDTO> queryItemByIds(@RequestParam("ids") Collection<Long> ids);

    @PutMapping("/items/stock/deduct")
    void deductStock(@RequestBody List<OrderDetailDTO> items);
}