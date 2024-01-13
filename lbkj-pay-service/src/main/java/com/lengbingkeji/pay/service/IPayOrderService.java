package com.lengbingkeji.pay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lengbingkeji.pay.domain.dto.PayApplyDTO;
import com.lengbingkeji.pay.domain.dto.PayOrderFormDTO;
import com.lengbingkeji.pay.domain.po.PayOrder;

/**
 * ClassName: IPayOrderService
 * Package: com.lengbingkeji.pay.service
 * Description:
 *      支付订单 服务类
 * @Author lengbingkeji
 * @Create 2024/1/13 17:37
 * @Version 1.0
 */
public interface IPayOrderService extends IService<PayOrder> {

    String applyPayOrder(PayApplyDTO applyDTO);

    void tryPayOrderByBalance(PayOrderFormDTO payOrderFormDTO);
}
