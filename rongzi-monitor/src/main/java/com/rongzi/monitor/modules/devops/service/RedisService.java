package com.rongzi.monitor.modules.devops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;

/**
 * @Auther: Administrator
 * @Date: 2018/7/2 0002 17:36
 * @Description:
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 删除多个对应的key
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    // 删除key *  正则
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    // 删除对应的key
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    // 读取redis中数据
    public Object get(final String key) {
        Object result = null;
        ValueOperations operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    // 获取正则对应的key的集合
    public Set findKeys(String pattern){
        Set keys = redisTemplate.keys(pattern);
        return keys;

    }

    // 根据正则表达式来验证key是否存在
    public boolean findKeysExist(String pattern){

        Set keys = redisTemplate.keys(pattern);
        if(keys.size()>0){
            return true;
        }else{
            return false;
        }
    }

    // 判断redis中是否有对应的key
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

}
