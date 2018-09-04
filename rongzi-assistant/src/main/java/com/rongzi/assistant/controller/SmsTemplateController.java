package com.rongzi.assistant.controller;

import com.alibaba.fastjson.JSON;
import com.rongzi.assistant.model.SmsTemplate;
import com.rongzi.assistant.service.SmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sms")
public class SmsTemplateController {


    @Autowired
    SmsTemplateService smsTemplateService;

    @GetMapping("/templates")
    public Map<String, Object> getSmsTemplates() {


        List<SmsTemplate> resultList = smsTemplateService.findAllsmsTemplates();

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("msg", "操作成功");
        resultMap.put("code", 0);
        resultMap.put("data", JSON.toJSON(resultList));

        return resultMap;

    }
}
