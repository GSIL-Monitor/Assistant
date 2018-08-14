package com.rongzi.monitor.modules.devops.service;

import com.rongzi.monitor.modules.base.BaseJunit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @Auther: Administrator
 * @Date: 2018/7/5 0005 19:28
 * @Description:
 */
public class RedisServiceTest extends BaseJunit{

    @Autowired
    RedisService redisService;

    @Test
    public void set() {
    }

    @Test
    public void set1() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void removePattern() {

        String data="aaa";
        redisService.removePattern(data+"*");
    }

    @Test
    public void remove1() {
    }

    @Test
    public void exists() {

        boolean exists = redisService.exists("aaa*");

        System.out.println(exists);
    }

    @Test
    public void get() {
    }

    @Test
    public void findKeys() {

        String data="aa";

        Set keys = redisService.findKeys(data + "*");

        if (keys.size()>0){
            System.out.println(true);
        }
    }
}