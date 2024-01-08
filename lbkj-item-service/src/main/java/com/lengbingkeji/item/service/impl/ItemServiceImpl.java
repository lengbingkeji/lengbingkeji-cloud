package com.lengbingkeji.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lengbingkeji.common.exception.BizIllegalException;
import com.lengbingkeji.common.utils.BeanUtils;
import com.lengbingkeji.item.domain.dto.ItemDTO;
import com.lengbingkeji.item.domain.dto.OrderDetailDTO;
import com.lengbingkeji.item.domain.po.Item;
import com.lengbingkeji.item.mapper.ItemMapper;
import com.lengbingkeji.item.service.IItemService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: ItemServiceImpl
 * Package: com.lengbingkeji.item.service.impl
 * Description:
 *      商品表 服务实现类
 * @Author lengbingkeji
 * @Create 2024/1/8 16:14
 * @Version 1.0
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    @Override
    public void deductStock(List<OrderDetailDTO> items) {
        String sqlStatement = "com.lengbingkeji.item.mapper.ItemMapper.updateStock";
        boolean r = false;
        try {
            r = executeBatch(items, (sqlSession, entity) -> sqlSession.update(sqlStatement, entity));
        } catch (Exception e) {
            log.error("更新库存异常", e);
            return;
        }
        if (!r) {
            throw new BizIllegalException("库存不足！");
        }
    }

    @Override
    public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
        return BeanUtils.copyList(listByIds(ids), ItemDTO.class);
    }
}