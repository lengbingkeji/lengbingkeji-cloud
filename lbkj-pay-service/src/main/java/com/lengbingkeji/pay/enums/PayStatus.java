package com.lengbingkeji.pay.enums;

import lombok.Getter;

/**
 * ClassName: PayStatus
 * Package: com.lengbingkeji.pay.enums
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 17:42
 * @Version 1.0
 */
@Getter
public enum PayStatus {
    NOT_COMMIT(0, "未提交"),
    WAIT_BUYER_PAY(1, "待支付"),
    TRADE_CLOSED(2, "已关闭"),
    TRADE_SUCCESS(3, "支付成功"),
    TRADE_FINISHED(3, "支付成功"),
    ;
    private final int value;
    private final String desc;

    PayStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public boolean equalsValue(Integer value){
        if (value == null) {
            return false;
        }
        return getValue() == value;
    }
}
