package com.lengbingkeji.common.utils;

/**
 * ClassName: Convert
 * Package: com.lengbingkeji.common.utils
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 10:30
 * @Version 1.0
 */
/**
 * 对原对象进行计算，设置到目标对象中
 **/
public interface Convert<R,T>{
    void convert(R origin, T target);
}
