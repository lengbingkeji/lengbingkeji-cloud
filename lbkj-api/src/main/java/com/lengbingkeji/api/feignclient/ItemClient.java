package com.lengbingkeji.api.feignclient;

import com.lengbingkeji.api.dto.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
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
public interface ItemClient {
    @GetMapping("/items")
    List<ItemDTO> queryItemByIds(@RequestParam("ids") Collection<Long> ids);
}