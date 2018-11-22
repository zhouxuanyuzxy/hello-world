package com.zxy.demo.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxy.demo.entity.User;
import com.zxy.demo.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/user")
@Api
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserMapper userMapper;
    @Autowired
    public UserController(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @GetMapping
    @ApiOperation(value = "用户名查询用户")
    @ApiImplicitParam(name = "username", value = "用户名", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY)
    public List<User> getUserByUserName(String userName){
        int a = 0;
        return userMapper.select(new User(userName,null));
    }

    @GetMapping("/getUserByUserProperties")
    @ApiOperation(value = "用户名或密码查询用户")
    public List<User> getUserByUserProperties(User user){
        return userMapper.select(user);
    }


    @GetMapping("getUserListByPager")
    public PageInfo getUserListByPager(){
        final PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> this.userMapper.selectAll());
        log.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());

        PageHelper.startPage(1, 10).setOrderBy("id desc");

        final PageInfo<User> userPageInfo = new PageInfo<>(this.userMapper.selectAll());
        log.info("[普通写法] - [{}]", userPageInfo);
        return pageInfo;
    }



}
