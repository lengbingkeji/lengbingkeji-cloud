package com.lengbingkeji.item.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ClassName: OrderDetailDTO
 * Package: com.lengbingkeji.item.domain.dto
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 16:11
 * @Version 1.0
 */
@ApiModel(description = "订单明细条目")
@Data
@Accessors(chain = true)
public class OrderDetailDTO {
    @ApiModelProperty("商品id")
    private Long itemId;
    @ApiModelProperty("商品购买数量")
    private Integer num;
}
