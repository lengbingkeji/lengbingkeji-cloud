package com.lengbingkeji.item;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: ItemServiceApplication
 * Package: com.lengbingkeji.item
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 15:09
 * @Version 1.0
 */
@MapperScan("com.lengbingkeji.item.mapper")
@SpringBootApplication
public class ItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class, args);
    }
}
