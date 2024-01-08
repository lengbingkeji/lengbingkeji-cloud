package com.lengbingkeji.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lengbingkeji.cart.domain.dto.CartFormDTO;
import com.lengbingkeji.cart.domain.po.Cart;
import com.lengbingkeji.cart.domain.vo.CartVO;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: ICartService
 * Package: com.lengbingkeji.cart.service
 * Description:
 *      订单详情表 服务类
 * @Author lengbingkeji
 * @Create 2024/1/8 17:09
 * @Version 1.0
 */
public interface ICartService extends IService<Cart> {

    void addItem2Cart(CartFormDTO cartFormDTO);

    List<CartVO> queryMyCarts();

    void removeByItemIds(Collection<Long> itemIds);
}
