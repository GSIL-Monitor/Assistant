package com.rongzi.assistant.controller;

import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.service.CallRecordService;
import com.rongzi.util.ValidatorParamUtil;
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
    public Map<String, Object> syncRecords(@RequestBody @Valid List<CallRecord> callRecord, BindingResult bindingResult) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> bindingResultMap = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {

            ValidatorParamUtil.validatorParams(bindingResult, resultMap, bindingResultMap);

        } else {
            callRecordService.syncCallRecordsFromMobileToSystem(callRecord);

            resultMap.put("msg", "操作成功");
            resultMap.put("code", 0);
            resultMap.put("data", null);


        }
        return resultMap;
    }


}
