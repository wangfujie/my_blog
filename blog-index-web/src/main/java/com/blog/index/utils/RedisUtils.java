package com.blog.index.utils;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

/**
 * @author wangfujie
 * @date 2018-08-31 14:52
 * @description Redis工具类
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;
    /**
     * 默认过期时长，一天，单位：秒
     */
     public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
     /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;
    private final static Gson gson = new Gson();

    /**
     * 添加数据，指定过期时长
     */
    public void set(String key, Object value, long expire){
        valueOperations.set(key, toJSONString(value));
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 添加数据，默认过期时长一天
     */
    public void set(String key, Object value){
        set(key, value, DEFAULT_EXPIRE);
    }

    /**
     * redis计数器
     * @param key 计数器key
     * @param count 设置每次增加的计数器数
     * @param expire 设置过期时间
     */
    public long setMyIncr(String key, int count, long expire){
        long thisCount = redisTemplate.opsForValue().increment(key, count);
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        return thisCount;
    }

    /**
     * 通过key，获取指定转换对象的数据，并设置过期时间
     */
    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    /**
     * 通过key，获取指定转换对象的数据
     */
    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    /**
     * 通过key，获取对应字符串，并设置过期时长
     */
    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    /**
     * 通过key，获取对应字符串
     */
    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    /**
     * 通过key删除数据
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 将对象转成json字符串
     */
    private String toJSONString(Object object) {
        if(object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String){
            return String.valueOf(object);
        }
        return gson.toJson(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz){
        return gson.fromJson(json, clazz);
    }
}