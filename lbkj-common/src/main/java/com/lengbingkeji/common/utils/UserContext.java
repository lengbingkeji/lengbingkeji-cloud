package com.lengbingkeji.common.utils;

/**
 * ClassName: UserContext
 * Package: com.lengbingkeji.common.utils
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 10:32
 * @Version 1.0
 */
public class UserContext {
    private static final ThreadLocal<Long> tl = new ThreadLocal<>();

    /**
     * 保存当前登录用户信息到ThreadLocal
     * @param userId 用户id
     */
    public static void setUser(Long userId) {
        tl.set(userId);
    }

    /**
     * 获取当前登录用户信息
     * @return 用户id
     */
    public static Long getUser() {
        return tl.get();
    }

    /**
     * 移除当前登录用户信息
     */
    public static void removeUser(){
        tl.remove();
    }
}