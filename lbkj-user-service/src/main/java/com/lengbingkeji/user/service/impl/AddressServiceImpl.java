package com.lengbingkeji.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lengbingkeji.user.domain.po.Address;
import com.lengbingkeji.user.mapper.AddressMapper;
import com.lengbingkeji.user.service.IAddressService;
import org.springframework.stereotype.Service;

/**
 * ClassName: AddressServiceImpl
 * Package: com.lengbingkeji.user.service.impl
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/13 12:34
 * @Version 1.0
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}