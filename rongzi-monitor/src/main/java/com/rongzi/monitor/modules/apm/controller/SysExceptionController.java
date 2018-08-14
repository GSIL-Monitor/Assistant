package com.rongzi.monitor.modules.apm.controller;

import com.rongzi.monitor.modules.apm.service.SysExceptionService;
import com.rongzi.monitor.modules.apm.wrapper.SysExceptionWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/apm")
public class SysExceptionController {

    private static String PREFIX = "/apm/exception/";

    @Autowired
    private SysExceptionService sysExceptionService;

    @RequestMapping("/exception/sys")
    public String index() {
        return PREFIX + "sysException.html";
    }

    /**
     * Description: 根据条件来查询所有的系统异常
     *
     * @param: [condition]
     * @return: java.lang.Object
     * @auther: Administrator
     * @date: 2018/5/16 0016 14:45
     */
    @RequestMapping("/sysException/list")
    @ResponseBody
    public Object findAllExceptions(@RequestParam(required = true) String OccurDate) {
        List<Map<String, Object>> list = sysExceptionService.getSysExceptionsAllByOccurDate(OccurDate);
        list = (List<Map<String, Object>>) new SysExceptionWarpper(list).warp();
        return list;
    }


}
