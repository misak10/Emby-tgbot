package com.aurora.emby.common.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;


@Slf4j
public class SnowFlakeUtil {
    private static long workerId = 0;
    private static long dataCenterId = 1;
    private static Snowflake snowflake = IdUtil.createSnowflake(workerId, dataCenterId);

    @PostConstruct
    public void init() {
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workId: {}", workerId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("当前机器的workId获取失败", e);
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public static synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public static synchronized long snowflakeId(long workerId, long dataCenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, dataCenterId);
        return snowflake.nextId();
    }
}
