package com.lengbingkeji.item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lengbingkeji.item.domain.dto.ItemDTO;
import com.lengbingkeji.item.domain.dto.OrderDetailDTO;
import com.lengbingkeji.item.domain.po.Item;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: IItemService
 * Package: com.lengbingkeji.item.service
 * Description:
 *      商品表 服务类
 * @Author lengbingkeji
 * @Create 2024/1/8 16:12
 * @Version 1.0
 */
public interface IItemService extends IService<Item> {

    void deductStock(List<OrderDetailDTO> items);

    List<ItemDTO> queryItemByIds(Collection<Long> ids);
}

