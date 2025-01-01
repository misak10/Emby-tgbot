CREATE TABLE `t_user`
(
    `id`      int      NOT NULL AUTO_INCREMENT COMMENT 'id',
    `tg_name`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'Telegram 用户名',
    `user_id`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户的 Telegram ID',
    `name`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户的姓名',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    `white`       int(1) unsigned zerofill DEFAULT '0' COMMENT '白名单标识，0 表示非白名单，1 表示白名单',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表，用于存储 Telegram 用户及其相关信息';
