package com.lengbingkeji.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ClassName: OrderDetailDTO
 * Package: com.lengbingkeji.api.dto
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 16:19
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
