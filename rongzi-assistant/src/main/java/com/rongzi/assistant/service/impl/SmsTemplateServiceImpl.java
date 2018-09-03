package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.common.context.UserContextHolder;
import com.rongzi.assistant.dao.SmsTemplateMapper;
import com.rongzi.assistant.model.SmsTemplate;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.SmsTemplateService;
import com.rongzi.config.aop.CityDataSource;
import com.rongzi.config.aop.CityDatasourceEnum;
import com.rongzi.core.constant.DatasourceEnum;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
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
    @CityDataSource(name = CityDatasourceEnum.DATA_SOURCE_CITY)
    public List<SmsTemplate> findAllsmsTemplates() {

        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
//        DataSourceContextHolder.setDataSourceType(currentUser.getCityCode());

        String empCode = currentUser.getEmpCode();

        List<SmsTemplate> smsTemplates = smsTemplateMapper.queryAllsmsTemplates(empCode);
//        DataSourceContextHolder.clearDataSourceType();

        return smsTemplates;
    }
}
