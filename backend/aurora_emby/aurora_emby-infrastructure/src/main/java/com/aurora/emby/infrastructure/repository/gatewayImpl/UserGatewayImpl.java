package com.aurora.emby.infrastructure.repository.gatewayImpl;

import cn.hutool.core.convert.Convert;
import com.aurora.emby.domain.bean.User;
import com.aurora.emby.domain.gateway.UserGateway;
import com.aurora.emby.infrastructure.repository.mapper.UserMapper;
import com.aurora.emby.infrastructure.repository.user.UserDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class UserGatewayImpl implements UserGateway {


    @Resource
    private UserMapper userMapper;


    @Override
    public  int insertUser(User user){
        UserDO userDO = Convert.convert(UserDO.class, user);
        return userMapper.insert(userDO);
    }


}
