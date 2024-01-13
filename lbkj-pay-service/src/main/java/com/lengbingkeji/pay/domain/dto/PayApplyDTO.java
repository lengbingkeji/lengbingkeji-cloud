package com.lengbingkeji.pay.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * ClassName: PayApplyDTO
 * Package: com.lengbingkeji.pay.domain.dto
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 17:31
 * @Version 1.0
 */
@Data
@Builder
@ApiModel(description = "支付下单表单实体")
public class PayApplyDTO {
    @ApiModelProperty("业务订单id不能为空")
    @NotNull(message = "业务订单id不能为空")
    private Long bizOrderNo;
    @ApiModelProperty("支付金额必须为正数")
    @Min(value = 1, message = "支付金额必须为正数")
    private Integer amount;
    @ApiModelProperty("支付渠道编码不能为空")
    @NotNull(message = "支付渠道编码不能为空")
    private String payChannelCode;
    @ApiModelProperty("支付方式不能为空")
    @NotNull(message = "支付方式不能为空")
    private Integer payType;
    @ApiModelProperty("订单中的商品信息不能为空")
    @NotNull(message = "订单中的商品信息不能为空")
    private String orderInfo;
}