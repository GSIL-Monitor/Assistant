package com.rongzi.assistant.controller;

import com.rongzi.assistant.common.tips.AssistantTip;
import com.rongzi.assistant.common.util.ValidatorParamUtil;
import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.service.CallRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/call/")
public class CallRecordController {


    @Autowired
    CallRecordService callRecordService;

    /**
     * 同步通话记录到销售系统
     *
     * @param callRecord
     * @return
     */
    @PostMapping("/syncRecords")
    public AssistantTip syncRecords(@RequestBody @Valid List<CallRecord> callRecord, BindingResult bindingResult) {

        AssistantTip assistantTip = new AssistantTip();
        Map<String, Object> bindingResultMap = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            ValidatorParamUtil.validatorParams(bindingResult, assistantTip, bindingResultMap);
        } else {
            callRecordService.syncCallRecordsFromMobileToSystem(callRecord);
            assistantTip = AssistantTip.ok();
        }
        return assistantTip;
    }


}
