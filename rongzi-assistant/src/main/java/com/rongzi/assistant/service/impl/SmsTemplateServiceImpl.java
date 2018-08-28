package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.dao.SmsTemplateMapper;
import com.rongzi.assistant.model.SmsTemplate;
import com.rongzi.assistant.service.SmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsTemplateServiceImpl implements SmsTemplateService{

    @Autowired
    SmsTemplateMapper smsTemplateMapper;

    @Override
    public List<SmsTemplate> findAllsmsTemplates() {

        return  smsTemplateMapper.queryAllsmsTemplates();
    }
}
