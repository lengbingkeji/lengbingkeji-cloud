package com.lengbingkeji.common.interceptors;

import cn.hutool.core.util.StrUtil;
import com.lengbingkeji.common.utils.UserContext;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: UserInfoInterceptor
 * Package: com.lengbingkeji.common.interceptors
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/17 15:16
 * @Version 1.0
 */
public class UserInfoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1、获取登录用户信息
        String userInfo = request.getHeader("user-info");

        // 2、判断是否获取了用户，如果有，存入ThreadLocal
        if (StrUtil.isNotBlank(userInfo)) {
            UserContext.setUser(Long.valueOf(userInfo));
        }

        // 3、放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //清理用户信息
        UserContext.removeUser();
    }
}
