package com.lengbingkeji.item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lengbingkeji.api.dto.OrderDetailDTO;
import com.lengbingkeji.item.domain.po.Item;
import org.apache.ibatis.annotations.Update;

/**
 * ClassName: ItemMapper
 * Package: com.lengbingkeji.item.mapper
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 15:17
 * @Version 1.0
 */
public interface ItemMapper extends BaseMapper<Item> {

    @Update("UPDATE item SET stock = stock - #{num} WHERE id = #{itemId}")
    void updateStock(OrderDetailDTO orderDetail);
}
