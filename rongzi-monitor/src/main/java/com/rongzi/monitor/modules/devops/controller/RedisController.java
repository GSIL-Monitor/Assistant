package com.rongzi.monitor.modules.devops.controller;

import com.rongzi.monitor.modules.devops.service.RedisService;
import com.rongzi.core.base.controller.BaseController;
import com.rongzi.core.base.tips.ErrorTip;
import com.rongzi.core.base.tips.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisController extends BaseController {

    private static String PREFIX = "/devops/redis/";


    @RequestMapping("")
    public String index() {
        return PREFIX + "redis.html";
    }


    @Autowired
    private RedisService redisService;

    @RequestMapping("/delete/{dataKey}")
    @ResponseBody
    public Tip deleteKey(@PathVariable("dataKey") String rediskey ){

        boolean exists = redisService.findKeysExist(rediskey);
        if(exists){
            redisService.removePattern(rediskey);
            return SUCCESS_TIP;
        }
        return new ErrorTip(500,"key不存在");
    }

}
