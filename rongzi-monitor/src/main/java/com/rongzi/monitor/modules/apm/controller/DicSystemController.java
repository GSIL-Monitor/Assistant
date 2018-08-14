package com.rongzi.monitor.modules.apm.controller;

import com.rongzi.monitor.modules.apm.service.DicSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/apm")
public class DicSystemController {


    @Autowired
    private DicSystemService dicSystemService;


    /**
     *
     * Description: 从系统表中获取所有的系统名称
     *
     * @param: []
     * @return: java.lang.Object
     * @auther: Administrator
     * @date: 2018/5/16 0016 14:04
     */
    @RequestMapping("/dicSystem/query")
    @ResponseBody
    public Object findAllSystemNames(){

        List<String> names = dicSystemService.getAllSystemNames();

        return names;
    }

}
