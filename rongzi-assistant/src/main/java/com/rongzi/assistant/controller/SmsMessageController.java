package com.rongzi.assistant.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.assistant.model.Customer;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.service.SmsMessageService;
import com.rongzi.core.page.PageInfoBT;
import org.beetl.core.statement.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/sms")
public class SmsMessageController {


    @Autowired
    SmsMessageService smsMessageService;


    /**
     * 获取销售系统短信信息到手机中
     *
     * @param empCode
     * @param customerCode
     * @param customerMobile
     * @param pageSize
     * @param pageIndex
     * @return
     */
    @PostMapping("/getMessages")
    public String findAllMsgFromSaleSystem(@RequestParam("empCode") String empCode
            , @RequestParam("customerCode") String customerCode
            , @RequestParam("customerMobile") String customerMobile
            , @RequestParam("pageSize") int pageSize
            , @RequestParam("pageIndex") int pageIndex
            ,@RequestParam("empName") String empName  ) {

//        Page page = new Page(pageIndex, pageSize);
        List<SmsMessage> msgs = smsMessageService.findMsgsFromSaleSystem(empCode, customerCode, customerMobile);
//        page.setRecords(msgs);

//        PageInfoBT<SmsMessage> pageinfo = new PageInfoBT<SmsMessage>(page);

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        resultMap.put("data", JSON.toJSONString(msgs));

        return JSON.toJSONString(resultMap);

    }


    /**
     * 同步短信到销售系统
     */
    @PostMapping("/addMessages")
    public String addMsgsToSaleSystem(@RequestParam("Msgs") String Msgs){


        List<SmsMessage> messages = JSON.parseArray(Msgs, SmsMessage.class);

        smsMessageService.addMsgsToSaleSystem(messages);

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        resultMap.put("data", null);

        return JSON.toJSONString(resultMap);
    }


}
