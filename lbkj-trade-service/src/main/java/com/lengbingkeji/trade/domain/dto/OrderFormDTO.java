package com.lengbingkeji.trade.domain.dto;

import com.lengbingkeji.api.dto.OrderDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * ClassName: OrderFormDTO
 * Package: com.lengbingkeji.trade.domain.dto
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 15:53
 * @Version 1.0
 */
@Data
@ApiModel(description = "交易下单表单实体")
public class OrderFormDTO {
    @ApiModelProperty("收货地址id")
    private Long addressId;
    @ApiModelProperty("支付类型")
    private Integer paymentType;
    @ApiModelProperty("下单商品列表")
    private List<OrderDetailDTO> details;
}
