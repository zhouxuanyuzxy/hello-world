package com.zxy.demo.service.imp;

import com.zxy.demo.entity.UserAddress;
import com.zxy.demo.service.UserAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    private static final Map<Long,UserAddress> DATABASES = new HashMap();

    static {
        DATABASES.put(1L, new UserAddress(1L, "黑龙江", "佳木斯","尖山"));
        DATABASES.put(2L, new UserAddress(2L, "北京", "北京","朝阳"));
        DATABASES.put(3L, new UserAddress(3L, "江苏", "南通","崇川区"));
    }


    private static final Logger log = LoggerFactory.getLogger(UserAddressServiceImpl.class);

    @Cacheable(value = "user", key = "#id")
    @Override
    public UserAddress get(Long id) {
        // TODO 我们就假设它是从数据库读取出来的
        log.info("进入 get 方法");
        return DATABASES.get(id);
    }

    @CachePut(value = "user", key = "#user.id")
    @Override
    public UserAddress saveOrUpdate(UserAddress user) {
        DATABASES.put(user.getId(), user);
        log.info("进入 saveOrUpdate 方法");
        return user;
    }

    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(Long id) {
        DATABASES.remove(id);
        log.info("进入 delete 方法");
    }
}
