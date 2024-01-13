package com.lengbingkeji.user.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.lengbingkeji.common.exception.BadRequestException;
import lombok.Getter;

/**
 * ClassName: UserStatus
 * Package: com.lengbingkeji.user.enums
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 12:25
 * @Version 1.0
 */
@Getter
public enum UserStatus {
    FROZEN(0, "禁止使用"),
    NORMAL(1, "已激活"),
    ;
    @EnumValue
    int value;
    String desc;

    UserStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static UserStatus of(int value) {
        if (value == 0) {
            return FROZEN;
        }
        if (value == 1) {
            return NORMAL;
        }
        throw new BadRequestException("账户状态错误");
    }
}
