package com.zxy.demo.service;

import com.zxy.demo.entity.UserAddress;

public interface UserAddressService {
    /**
     * 删除
     *
     * @param user 用户对象
     * @return 操作结果
     */
    UserAddress saveOrUpdate(UserAddress userAddress);

    /**
     * 添加
     *
     * @param id key值
     * @return 返回结果
     */
    UserAddress get(Long id);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(Long id);
}
