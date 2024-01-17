package com.lengbingkeji.gateway.filters;

import com.lengbingkeji.common.exception.UnauthorizedException;
import com.lengbingkeji.gateway.config.AuthProperties;
import com.lengbingkeji.gateway.util.JwtTool;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * ClassName: AuthGloblFilter
 * Package: com.lengbingkeji.gateway.filters
 * Description:
 *      登录过滤器
 * @Author lengbingkeji
 * @Create 2024/1/17 10:50
 * @Version 1.0
 */
@Component
@RequiredArgsConstructor
public class AuthGloblFilter implements GlobalFilter, Ordered {
    private final AuthProperties authProperties;
    private final JwtTool jwtTool;
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取request
        ServerHttpRequest request = exchange.getRequest();

        //2.判断是否需要做登录拦截
        if(isExclude(request.getPath().toString())){
            //放行
            return chain.filter(exchange);
        }

        //3.获取token
        String token = null;
        List<String> headers = request.getHeaders().get("authorization");
        if(headers != null && !headers.isEmpty()){
            token = headers.get(0);
        }

        //4.校验并解析token
        Long userId = null;
        try {
            userId = jwtTool.parseToken(token);
        }catch (UnauthorizedException e){
            //拦截，设置响应状态码为401
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //TODO 5.传递用户信息
        //System.out.println("userId = " + userId);
        String userInfo = userId.toString();
        ServerWebExchange swe = exchange.mutate()
                .request(builder -> builder.header("user-info", userInfo))
                .build();

        //6.放行
        //return chain.filter(exchange);
        return chain.filter(swe);
    }

    private boolean isExclude(String path){
        for(String pathPattern: authProperties.getExcludePaths()){
            if(antPathMatcher.match(pathPattern, path)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
