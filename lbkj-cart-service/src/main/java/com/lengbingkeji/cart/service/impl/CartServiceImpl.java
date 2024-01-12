package com.lengbingkeji.cart.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lengbingkeji.cart.domain.dto.CartFormDTO;
import com.lengbingkeji.cart.domain.dto.ItemDTO;
import com.lengbingkeji.cart.domain.po.Cart;
import com.lengbingkeji.cart.domain.vo.CartVO;
import com.lengbingkeji.cart.feignclient.ItemClient;
import com.lengbingkeji.cart.mapper.CartMapper;
import com.lengbingkeji.cart.service.ICartService;
import com.lengbingkeji.common.exception.BizIllegalException;
import com.lengbingkeji.common.utils.BeanUtils;
import com.lengbingkeji.common.utils.CollUtils;
import com.lengbingkeji.common.utils.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ClassName: CartServiceImpl
 * Package: com.lengbingkeji.cart.service.impl
 * Description:
 *      订单详情表 服务实现类
 * @Author lengbingkeji
 * @Create 2024/1/8 17:12
 * @Version 1.0
 */
@Service
//网络请求：第三步
@RequiredArgsConstructor
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    //private final IItemService itemService;
    //private final DiscoveryClient discoveryClient;
    //导入接口
    private final ItemClient itemClient;

    //网络请求：第二步
    // 方式一：
    // @Autowired
    // private RestTemplate restTemplate;

    //
    // 网络请求：第二步
    // 方式二：
    private final RestTemplate restTemplate;
    // public CartServiceImpl(RestTemplate restTemplate){
    //     this.restTemplate = restTemplate;
    // }

    @Override
    public void addItem2Cart(CartFormDTO cartFormDTO) {
        // 1.获取登录用户
        Long userId = UserContext.getUser();

        // 2.判断是否已经存在
        if(checkItemExists(cartFormDTO.getItemId(), userId)){
            // 2.1.存在，则更新数量
            baseMapper.updateNum(cartFormDTO.getItemId(), userId);
            return;
        }
        // 2.2.不存在，判断是否超过购物车数量
        checkCartsFull(userId);

        // 3.新增购物车条目
        // 3.1.转换PO
        Cart cart = BeanUtils.copyBean(cartFormDTO, Cart.class);
        // 3.2.保存当前用户
        cart.setUserId(userId);
        // 3.3.保存到数据库
        save(cart);
    }

    @Override
    public List<CartVO> queryMyCarts() {
        // 1.查询我的购物车列表
        //List<Cart> carts = lambdaQuery().eq(Cart::getUserId, UserContext.getUser()).list();
        //List<Cart> carts = lambdaQuery().eq(Cart::getUserId, 1L).list();
        List<Cart> carts = baseMapper.selectList(1L);
        if (CollUtils.isEmpty(carts)) {
            return CollUtils.emptyList();
        }

        // 2.转换VO
        List<CartVO> vos = BeanUtils.copyList(carts, CartVO.class);

        // 3.处理VO中的商品信息
        handleCartItems(vos);

        // 4.返回
        return vos;
    }

    private void handleCartItems(List<CartVO> vos) {
        //TODO 1.获取商品id
        Set<Long> itemIds = vos.stream().map(CartVO::getItemId).collect(Collectors.toSet());
        // 2.查询商品
        //List<ItemDTO> items = itemService.queryItemByIds(itemIds);
/*
        //以下是通过nacos获取服务新添加的代码：start
        //2.1、根据服务名称获取服务的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("LBKJ-ITEM-SERVICE");
        System.out.println("instances实例：" + instances);
        if(CollUtil.isEmpty(instances)){
            return;
        }
        //2.2、手写负载均衡，从实例列表中挑选一个实例
        ServiceInstance instance = instances.get(RandomUtil.randomInt(instances.size()));
        //获取uri
        URI uri = instance.getUri();
        //以上是通过nacos获取服务新添加的代码：end

        //2.1、(利用 RestTemplate 发起http请求，得到http的响应)
        //网络请求：第四步
        ResponseEntity<List<ItemDTO>> response = restTemplate.exchange(
                //"http://localhost:8081/items?ids={ids}",
                uri + "/items?ids={ids}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ItemDTO>>() {
                },
                Map.of("ids", CollUtil.join(itemIds, ","))
        );

        //2.2、解析响应
        if(!response.getStatusCode().is2xxSuccessful()){
            //查询失败，直接结束
            return;
        }
        List<ItemDTO> items = response.getBody();
*/
        List<ItemDTO> items = itemClient.queryItemByIds(itemIds);
        if (CollUtils.isEmpty(items)) {
            return;
        }
        // 3.转为 id 到 item的map
        Map<Long, ItemDTO> itemMap = items.stream().collect(Collectors.toMap(ItemDTO::getId, Function.identity()));
        // 4.写入vo
        for (CartVO v : vos) {
            ItemDTO item = itemMap.get(v.getItemId());
            if (item == null) {
                continue;
            }
            v.setNewPrice(item.getPrice());
            v.setStatus(item.getStatus());
            v.setStock(item.getStock());
        }
    }

    @Override
    public void removeByItemIds(Collection<Long> itemIds) {
        // 1.构建删除条件，userId和itemId
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<Cart>();
        queryWrapper.lambda()
                .eq(Cart::getUserId, UserContext.getUser())
                .in(Cart::getItemId, itemIds);
        // 2.删除
        remove(queryWrapper);
    }

    private void checkCartsFull(Long userId) {
        int count = lambdaQuery().eq(Cart::getUserId, userId).count();
        if (count >= 10) {
            throw new BizIllegalException(StrUtil.format("用户购物车课程不能超过{}", 10));
        }
    }

    private boolean checkItemExists(Long itemId, Long userId) {
        int count = lambdaQuery()
                .eq(Cart::getUserId, userId)
                .eq(Cart::getItemId, itemId)
                .count();
        return count > 0;
    }
}

