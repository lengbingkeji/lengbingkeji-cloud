package com.lengbingkeji.cart.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName: CartFormDTO
 * Package: com.lengbingkeji.cart.domain.dto
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 17:02
 * @Version 1.0
 */
@Data
@ApiModel(description = "新增购物车商品表单实体")
public class CartFormDTO {
    @ApiModelProperty("商品id")
    private Long itemId;
    @ApiModelProperty("商品标题")
    private String name;
    @ApiModelProperty("商品动态属性键值集")
    private String spec;
    @ApiModelProperty("价格,单位：分")
    private Integer price;
    @ApiModelProperty("商品图片")
    private String image;
}
