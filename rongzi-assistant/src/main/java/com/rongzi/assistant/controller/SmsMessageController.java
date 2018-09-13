package com.rongzi.assistant.controller;

import com.alibaba.fastjson.JSON;
import com.rongzi.assistant.common.tips.AssistantTip;
import com.rongzi.assistant.common.util.ValidatorParamUtil;
import com.rongzi.assistant.model.SmsMessage;
import com.rongzi.assistant.model.SystemMessageParam;
import com.rongzi.assistant.service.sms.SmsMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sms")
public class SmsMessageController {

    private Logger logger= LoggerFactory.getLogger(SmsMessageController.class);


    @Autowired
    SmsMessageService smsMessageService;


    /**
     * 获取销售系统短信信息到手机中
     *
     * @param
     * @return
     */
    @PostMapping("/getMessages")
    public AssistantTip findAllMsgFromSaleSystem(@RequestBody @Valid SystemMessageParam systemMessageParam, BindingResult bindingResult) {
        long time=System.currentTimeMillis();
        logger.info("******短信同步请求时间：*********"+new Date());
        AssistantTip assistantTip = new AssistantTip();
        Map<String, Object> bindingResultMap = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            assistantTip = ValidatorParamUtil.getAssistantTip(bindingResult, assistantTip, bindingResultMap);
        } else {
            List<SmsMessage> msgs = smsMessageService.findMsgsFromSaleSystem(systemMessageParam.getEmpCode(), systemMessageParam.getCustomerCode(), systemMessageParam.getCustomerMobile());
            logger.info("******同步短信返回时间毫秒差：*********"+(System.currentTimeMillis()-time));
            assistantTip = AssistantTip.ok(JSON.toJSON(msgs));
        }
        return assistantTip;
    }


    /**
     * 同步手机短信到销售系统
     */
    @PostMapping("/addMessages")
    public AssistantTip addMsgsToSaleSystem(@RequestBody @Valid List<SmsMessage> msgs, BindingResult bindingResult) {

        logger.info("开始接受的数据是：------------------");
        for(int i=0;i<msgs.size();i++){
            logger.info(msgs.get(i).toString());
        }
        logger.info("接受完毕的数据是：------------------");

        logger.info("*********************开始同步短信，时间是："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        AssistantTip assistantTip = new AssistantTip();
        Map<String, Object> bindingResultMap = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            assistantTip = ValidatorParamUtil.getAssistantTip(bindingResult, assistantTip, bindingResultMap);
        } else {
            Date lastSmsSyncTime= smsMessageService.addMsgsToSaleSystem(msgs);
            assistantTip = AssistantTip.ok(lastSmsSyncTime);
        }
        return assistantTip;
    }
}
