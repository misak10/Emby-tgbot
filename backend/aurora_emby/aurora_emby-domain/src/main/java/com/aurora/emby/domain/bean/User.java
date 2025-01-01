package com.aurora.emby.domain.bean;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private Integer id;

    // Telegram 用户名
    private String tgName;

    // Telegram 用户ID
    private String userId;

    // 用户姓名
    private String name;

    // 白名单标识，0 表示非白名单，1 表示白名单
    private Integer white;
}
