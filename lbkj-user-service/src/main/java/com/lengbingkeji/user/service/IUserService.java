package com.lengbingkeji.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lengbingkeji.user.domain.dto.LoginFormDTO;
import com.lengbingkeji.user.domain.po.User;
import com.lengbingkeji.user.domain.vo.UserLoginVO;

/**
 * ClassName: IUserService
 * Package: com.lengbingkeji.user.service
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 12:33
 * @Version 1.0
 */
public interface IUserService extends IService<User> {

    UserLoginVO login(LoginFormDTO loginFormDTO);

    void deductMoney(String pw, Integer totalFee);
}