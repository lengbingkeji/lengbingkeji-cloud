package com.lengbingkeji.trade.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lengbingkeji.trade.domain.po.OrderDetail;
import com.lengbingkeji.trade.mapper.OrderDetailMapper;
import com.lengbingkeji.trade.service.IOrderDetailService;
import org.springframework.stereotype.Service;

/**
 * ClassName: OrderDetailServiceImpl
 * Package: com.lengbingkeji.trade.service.impl
 * Description:
 *      订单详情表 服务实现类
 * @Author lengbingkeji
 * @Create 2024/1/13 16:05
 * @Version 1.0
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

}
