package com.lengbingkeji.pay.enums;
import cn.hutool.core.util.StrUtil;
import lombok.Getter;

/**
 * ClassName: PayChannel
 * Package: com.lengbingkeji.pay.enums
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 17:41
 * @Version 1.0
 */
@Getter
public enum PayChannel {
    wxPay("微信支付"),
    aliPay("支付宝支付"),
    balance("余额支付"),
    ;

    private final String desc;

    PayChannel(String desc) {
        this.desc = desc;
    }

    public static String desc(String value){
        if (StrUtil.isBlank(value)) {
            return "";
        }
        return PayChannel.valueOf(value).getDesc();
    }
}
