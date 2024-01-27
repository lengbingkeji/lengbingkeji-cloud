package com.lengbingkeji.api.feignclient.fallback;

import com.lengbingkeji.api.dto.ItemDTO;
import com.lengbingkeji.api.dto.OrderDetailDTO;
import com.lengbingkeji.api.feignclient.ItemClient;
import com.lengbingkeji.common.exception.BizIllegalException;
import com.lengbingkeji.common.utils.CollUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collection;
import java.util.List;

/**
 * ClassName: ItemClientFallback
 * Package: com.lengbingkeji.api.feignclient.fallback
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/27 15:02
 * @Version 1.0
 */
@Slf4j
public class ItemClientFallback implements FallbackFactory<ItemClient> {
    @Override
    public ItemClient create(Throwable cause) {
        return new ItemClient() {
            @Override
            public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
                log.error("远程调用ItemClient#queryItemByIds方法出现异常，参数：{}", ids, cause);
                // 查询购物车允许失败，查询失败，返回空集合
                return CollUtils.emptyList();
            }

            @Override
            public void deductStock(List<OrderDetailDTO> items) {
                // 库存扣减业务需要触发事务回滚，查询失败，抛出异常
                throw new BizIllegalException(cause);
            }
        };
    }
}
