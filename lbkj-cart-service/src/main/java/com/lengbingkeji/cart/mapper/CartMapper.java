package com.lengbingkeji.cart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lengbingkeji.cart.domain.po.Cart;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * ClassName: CartMapper
 * Package: com.lengbingkeji.cart.mapper
 * Description:
 *      订单详情表 Mapper 接口
 * @Author lengbingkeji
 * @Create 2024/1/8 17:05
 * @Version 1.0
 */
public interface CartMapper extends BaseMapper<Cart> {

    @Update("UPDATE cart SET num = num + 1 WHERE user_id = #{userId} AND item_id = #{itemId}")
    void updateNum(@Param("itemId") Long itemId, @Param("userId") Long userId);
}
