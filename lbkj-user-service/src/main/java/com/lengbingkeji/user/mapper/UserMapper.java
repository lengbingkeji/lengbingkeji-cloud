package com.lengbingkeji.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lengbingkeji.user.domain.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * ClassName: UserMapper
 * Package: com.lengbingkeji.user.mapper
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 12:29
 * @Version 1.0
 */
public interface UserMapper extends BaseMapper<User> {
    @Update("update user set balance = balance - ${totalFee} where id = #{userId}")
    void updateMoney(@Param("userId") Long userId, @Param("totalFee") Integer totalFee);
}
