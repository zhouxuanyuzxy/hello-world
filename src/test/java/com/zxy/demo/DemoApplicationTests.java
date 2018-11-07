package com.zxy.demo;

import com.zxy.demo.entity.UserAddress;
import com.zxy.demo.service.UserAddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);


    @Autowired
    private UserAddressService userAddressService;


    @Test
    public void get() {
        final UserAddress user = userAddressService.saveOrUpdate(new UserAddress(5L, "广东", "东莞","厚街"));
        log.info("[saveOrUpdate] - [{}]", user.getProvince());
        final UserAddress user1 = userAddressService.get(5L);
        log.info("[get] - [{}]", user1.getProvince());
        userAddressService.delete(5L);

    }

}
