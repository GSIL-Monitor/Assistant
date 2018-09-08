package com.rongzi.assistant.controller;

import com.alibaba.fastjson.JSON;
import com.rongzi.assistant.model.SmsTemplate;
import com.rongzi.assistant.service.sms.SmsTemplateService;
import com.rongzi.assistant.common.tips.AssistantTip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sms")
public class SmsTemplateController {


    @Autowired
    SmsTemplateService smsTemplateService;

    @GetMapping("/templates")
    public AssistantTip getSmsTemplates() {

        List<SmsTemplate> resultList = smsTemplateService.findAllsmsTemplates();
        return AssistantTip.ok(JSON.toJSON(resultList));
    }
}
