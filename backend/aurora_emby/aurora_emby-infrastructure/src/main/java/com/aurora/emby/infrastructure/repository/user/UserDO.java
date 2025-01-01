package com.aurora.emby.infrastructure.repository.user;

import com.aurora.emby.infrastructure.repository.CommonDO;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户信息实体类，用于存储 Telegram 用户及其相关信息
 */
@Data
@TableName("users")  // 指定表名
public class UserDO extends CommonDO {

    // 主键字段
    @TableId
    private Integer id;

    // Telegram 用户名
    @TableField("tg_name")
    private String tgName;

    // Telegram 用户ID
    @TableField("user_id")
    private String userId;

    // 用户姓名
    @TableField("name")
    private String name;

    // 白名单标识，0 表示非白名单，1 表示白名单
    @TableField("white")
    private Integer white;
}


