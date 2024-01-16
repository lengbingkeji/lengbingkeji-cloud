package com.lengbingkeji.gateway.filters;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * ClassName: LbkjPrintAnyGatewayFilterFactory
 * Package: com.lengbingkeji.gateway.filters
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/16 17:06
 * @Version 1.0
 */
@Component
//步骤五：修改泛型（由 Object 改为 LbkjPrintAnyGatewayFilterFactory.Config）
//public class LbkjPrintAnyGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {
public class LbkjPrintAnyGatewayFilterFactory extends AbstractGatewayFilterFactory<LbkjPrintAnyGatewayFilterFactory.Config> {
    @Override
    //步骤六：修改泛型（由 Object 改为 Config）
    //public GatewayFilter apply(Object config) {
    public GatewayFilter apply(Config config) {
        //方式一：匿名内部类
        /*
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                System.out.println("LbkjPrintAny过滤器running....");
                return chain.filter(exchange);
            }
        };
        */

        //方式二：可以定义顺序
        /*
        return new OrderedGatewayFilter(new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                System.out.println("LbkjPrintAny过滤器(可以定义顺序)running....");
                return chain.filter(exchange);
            }
        },1);
        */

        //方式二：可以定义顺序、可以传递参数
        //步骤一：
        return new OrderedGatewayFilter(new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String a = config.getA();
                String b = config.getB();
                String c = config.getC();
                System.out.println("a =" + a + ", b =" + b + ", c =" + c);
                System.out.println("LbkjPrintAny过滤器(可以定义顺序、可以传递参数)running....");
                return chain.filter(exchange);
            }
        },1);
    }

    //步骤二：自定义配置属性，成员变量名称很重要，下面会用到
    @Data
    public static class Config{
        private String a;
        private String b;
        private String c;
    }

    //步骤三：将变量名称依次返回，顺序很重要，将来读取参数时需要按顺序获取
    @Override
    public List<String> shortcutFieldOrder() {
        return List.of("a", "b", "c");
    }

    //步骤四：将config字节码传递给父类，父类负责帮我们读取yaml配置
    public LbkjPrintAnyGatewayFilterFactory(){
        super(Config.class);
    }

    //步骤七：可以在 application.yml 配置文件中添加参数了（- LbkjPrintAny=1,2,3）
}
