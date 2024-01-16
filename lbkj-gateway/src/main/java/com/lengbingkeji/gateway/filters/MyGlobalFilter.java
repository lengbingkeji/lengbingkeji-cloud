package com.lengbingkeji.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName: MyGlobalFilter
 * Package: com.lengbingkeji.gateway.filters
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/16 16:31
 * @Version 1.0
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //TODO 模拟登录校验逻辑
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        System.out.println("请求头headers" + headers);

        //放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //过滤器执行顺序，值越小，优先级越高
        return 0;
    }
}
