package com.aurora.emby.common.utils;

/**
 * @author liweibing
 * @className RedisUtils
 * @description: TODO
 * @date 2021/8/18 9:38 上午
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private final String prefix="g0_gallery_";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    public RedisUtils(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, Object obj) {
        try {
            redisTemplate.opsForValue().set(prefix+key, obj);
        } catch (Exception e) {
            logger.error("Failed adding {}", obj, e);
        }
    }

    /**
     * 添加
     *
     * @param key
     * @param obj
     * @param timeout  过期时间
     * @param timeunit 时间单位
     */
    public void set(String key, Object obj, long timeout, TimeUnit timeunit) {
        try {
            redisTemplate.opsForValue().set(prefix+key, obj, timeout, timeunit);
        } catch (Exception e) {
            logger.error("Failed adding {}", obj, e);
        }
    }


    public void hashSet(String key, String field, Object obj) {
        try {
            redisTemplate.opsForHash().put(prefix+key, field, obj);
        } catch (Exception e) {
            logger.error("Failed adding {}", obj, e);
            e.printStackTrace();
        }
    }

    public Object hashGet(String key, String field) {
        try {
            return redisTemplate.opsForHash().get(prefix+key, field);
        } catch (Exception e) {
            logger.error("Failed getting {}", key, e);
            e.printStackTrace();
        }
        return null;
    }


    public HashMap<Object, Object> hashGetMap(String key) {
        try {
            return (HashMap<Object, Object>) redisTemplate.opsForHash().entries(prefix+key);
        } catch (Exception e) {
            logger.error("Failed getting {}", key, e);
            e.printStackTrace();
        }
        return null;
    }

    public void hashSet(String key, Map value) {
        try {
            redisTemplate.opsForHash().putAll(prefix+key, value);
        } catch (Exception e) {
            logger.error("Failed adding {}", value, e);
            e.printStackTrace();
        }
    }


    public void incr(String key) {
        try {
            redisTemplate.opsForValue().increment(prefix+key, 1L);
        } catch (Exception e) {
            logger.error("Failed incring {}", key, e);
            e.printStackTrace();
        }
    }


    public void expire(String key, long timeout, TimeUnit timeunit) {
        try {
            redisTemplate.expire(prefix+key, timeout, timeunit);
        } catch (Exception e) {
            logger.error("Failed expire {}", key, e);
            e.printStackTrace();
        }
    }


    /**
     * 删除
     *
     * @param key
     * @return true or false
     */
    public boolean delete(String key) {
        try {
            redisTemplate.delete(prefix+key);
            return true;
        } catch (Exception e) {
            logger.error("Failed deleting {}", key, e);
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        try {
            Object obj = redisTemplate.opsForValue().get(prefix+key);
            if (obj != null) {
                return obj;
            }
        } catch (Exception e) {
            logger.error("Failed getting {}", key, e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新
     *
     * @param key
     * @param obj
     */
    public void update(String key, Object obj) {
        try {
            redisTemplate.delete(prefix+key);
            redisTemplate.opsForValue().set(prefix+key, obj);
        } catch (Exception e) {
            logger.error("Failed updating {}", key, obj);
            e.printStackTrace();
        }
    }


    /**
     * 获取存活时间
     *
     * @param key
     * @return
     */
    public Long getExpireTime(String key) {
        try {
            long timeout = redisTemplate.getExpire(prefix+key);
            return timeout;
        } catch (Exception e) {
            logger.error("Failed get expire time {}", key, e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加入队列
     *
     * @param key
     * @param value
     * @return
     */
    public Long push(String key, Object value) {
        try {
            return redisTemplate.opsForList().leftPush(prefix+key, value);
        } catch (Exception e) {
            logger.error("Failed push {}", key, value);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 出列
     *
     * @param key
     * @return
     */
    public Object pop(String key) {
        try {
            return redisTemplate.opsForList().leftPop(prefix+key);
        } catch (Exception e) {
            logger.error("Failed pop {}", key);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 进栈
     *
     * @param key
     * @param value
     * @return
     */
    public Long in(String key, Object value) {
        try {
            return redisTemplate.opsForList().rightPush(prefix+key, value);
        } catch (Exception e) {
            logger.error("Failed in {}", key, value);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 出栈
     *
     * @param key
     * @return
     */
    public Object out(String key) {
        try {
            return redisTemplate.opsForList().leftPop(prefix+key);
        } catch (Exception e) {
            logger.error("Failed out {}", key);
            e.printStackTrace();
        }
        return null;

    }

    /**
     * @param key
     * @return
     */
    public Long length(String key) {
        try {
            return redisTemplate.opsForList().size(prefix+key);
        } catch (Exception e) {
            logger.error("Failed length {}", key);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> range(String key, int start, int end) {
        try {
            return redisTemplate.opsForList().range(prefix+key, start, end);
        } catch (Exception e) {
            logger.error("Failed range {}", key);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param key
     * @param i
     * @param value
     */
    public void remove(String key, long i, Object value) {
        try {
            redisTemplate.opsForList().remove(prefix+key, i, value);
        } catch (Exception e) {
            logger.error("Failed remove {}", key);
            e.printStackTrace();
        }
    }

    /**
     * @param key
     * @param index
     * @return
     */
    public String index(String key, long index) {
        try {
            return (String) redisTemplate.opsForList().index(prefix+key, index);
        } catch (Exception e) {
            logger.error("Failed index {}", key, index);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param key
     * @param index
     * @param value
     */

    public void set(String key, long index, String value) {
        try {
            redisTemplate.opsForList().set(prefix+key, index, value);
        } catch (Exception e) {
            logger.error("Failed set {}", key, index);
            e.printStackTrace();
        }
    }



}

