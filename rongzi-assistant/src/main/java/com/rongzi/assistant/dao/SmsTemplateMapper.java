package com.rongzi.assistant.dao;

import com.rongzi.assistant.model.SmsTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsTemplateMapper {


    List<SmsTemplate> queryAllsmsTemplates(@Param("empCode") String empCode);
}
