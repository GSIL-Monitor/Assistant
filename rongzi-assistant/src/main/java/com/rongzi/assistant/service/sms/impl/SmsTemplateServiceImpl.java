package com.rongzi.assistant.service.sms.impl;

import com.rongzi.assistant.common.datasource.AssistantDataSource;
import com.rongzi.assistant.common.datasource.DatasourceEnum;
import com.rongzi.assistant.common.web.context.UserContextHolder;
import com.rongzi.assistant.dao.SmsTemplateMapper;
import com.rongzi.assistant.model.SmsTemplate;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.sms.SmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsTemplateServiceImpl implements SmsTemplateService {

    @Autowired
    SmsTemplateMapper smsTemplateMapper;

    /**
     * 获取系统短信模板
     *
     * @return
     */
    @Override
    @AssistantDataSource(name = DatasourceEnum.DATA_SOURCE_CITY)
    public List<SmsTemplate> findAllsmsTemplates() {
        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        String empCode = currentUser.getEmpCode();
        List<SmsTemplate> smsTemplates = smsTemplateMapper.queryAllsmsTemplates(empCode);
        return smsTemplates;
    }

}
