package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.dao.SmsTemplateMapper;
import com.rongzi.assistant.model.SmsTemplate;
import com.rongzi.assistant.service.SmsTemplateService;
import com.rongzi.core.constant.DatasourceEnum;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsTemplateServiceImpl implements SmsTemplateService{

    @Autowired
    SmsTemplateMapper smsTemplateMapper;

    /**
     * 获取系统短信模板
     * @return
     */
    @Override
    public List<SmsTemplate> findAllsmsTemplates() {

        DataSourceContextHolder.setDataSourceType(DatasourceEnum.DATA_SOURCE_GUNS);

        return  smsTemplateMapper.queryAllsmsTemplates();
    }
}
