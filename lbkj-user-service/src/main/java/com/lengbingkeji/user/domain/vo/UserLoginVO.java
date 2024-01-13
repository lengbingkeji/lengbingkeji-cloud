package com.lengbingkeji.user.domain.vo;

import lombok.Data;

/**
 * ClassName: UserLoginVO
 * Package: com.lengbingkeji.user.domain.vo
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 12:27
 * @Version 1.0
 */
@Data
public class UserLoginVO {
    private String token;
    private Long userId;
    private String username;
    private Integer balance;
}

