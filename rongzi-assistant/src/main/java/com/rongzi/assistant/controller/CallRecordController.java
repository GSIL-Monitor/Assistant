package com.rongzi.assistant.controller;

import com.rongzi.assistant.common.tips.AssistantTip;
import com.rongzi.assistant.common.util.ValidatorParamUtil;
import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.service.CallRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/call/")
public class CallRecordController {

    private Logger logger= LoggerFactory.getLogger(CallRecordController.class);

    @Autowired
    CallRecordService callRecordService;

    /**
     * 同步通话记录到销售系统
     *
     * @param callRecord
     * @return
     */
    @PostMapping("/syncRecords")
    public AssistantTip syncRecords(@RequestBody @Valid  List<CallRecord> callRecord, BindingResult bindingResult) {
        AssistantTip assistantTip = new AssistantTip();
        Map<String, Object> bindingResultMap = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            assistantTip =ValidatorParamUtil.getAssistantTip(bindingResult, assistantTip, bindingResultMap);
        } else {
            Date lastCallRecordSyncTime = callRecordService.syncCallRecordsFromMobileToSystem(callRecord);
            logger.info("返回的毫秒数目是： "+lastCallRecordSyncTime.getTime()+"");
            assistantTip = AssistantTip.ok(lastCallRecordSyncTime.getTime());
        }
        return assistantTip;
    }
}
