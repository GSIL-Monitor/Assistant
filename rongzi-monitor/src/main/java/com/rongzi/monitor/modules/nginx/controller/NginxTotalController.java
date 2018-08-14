package com.rongzi.monitor.modules.nginx.controller;

import com.rongzi.monitor.modules.apm.wrapper.NginxTotalWrapper;
import com.rongzi.monitor.modules.nginx.service.NginxTotalService;
import com.rongzi.core.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by sun_y on 2018/7/11.
 */
@Controller
@RequestMapping("/nginx")
public class NginxTotalController extends BaseController {
    private static String PREFIX = "/nginx/";

    @Autowired
    private NginxTotalService nginxTotalService;

    @RequestMapping(value = "/actiontotalhistory")
    public String nginxtotalindex() {
        return PREFIX + "actiontotalhistory.html";
    }

    @RequestMapping(value = "/nginxtotalhistorylist")
    @ResponseBody
    public Object findAllNginxClientPage(@RequestParam(required = true) Integer timetype) {
        List<Map<String, Object>> list = nginxTotalService.querynginxtotalforpage(timetype);
        list = (List<Map<String, Object>>) new NginxTotalWrapper(list).warp();
        return list;
    }


}
