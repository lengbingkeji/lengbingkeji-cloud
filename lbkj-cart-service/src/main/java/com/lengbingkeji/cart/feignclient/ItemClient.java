//package com.lengbingkeji.cart.feignclient;
//
//import com.lengbingkeji.cart.domain.dto.ItemDTO;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Collection;
//import java.util.List;
//
///**
// * ClassName: ItemClient
// * Package: com.lengbingkeji.cart.feignclient
// * Description:
// *
// * @Author lengbingkeji
// * @Create 2024/1/12 17:30
// * @Version 1.0
// */
//@FeignClient("LBKJ-ITEM-SERVICE")
//public interface ItemClient {
//    @GetMapping("/items")
//    List<ItemDTO> queryItemByIds(@RequestParam("ids") Collection<Long> ids);
//}
