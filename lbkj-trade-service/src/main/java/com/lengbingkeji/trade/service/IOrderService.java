package com.lengbingkeji.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lengbingkeji.trade.domain.dto.OrderFormDTO;
import com.lengbingkeji.trade.domain.po.Order;

/**
 * ClassName: IOrderService
 * Package: com.lengbingkeji.trade.service
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 16:04
 * @Version 1.0
 */
public interface IOrderService extends IService<Order> {

    Long createOrder(OrderFormDTO orderFormDTO);

    void markOrderPaySuccess(Long orderId);
}
