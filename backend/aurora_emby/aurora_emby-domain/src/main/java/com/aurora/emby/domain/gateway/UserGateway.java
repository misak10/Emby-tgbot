package com.aurora.emby.domain.gateway;

import com.aurora.emby.domain.bean.User;

public interface UserGateway {

    int insertUser(User user);
}
