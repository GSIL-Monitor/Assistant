package com.rongzi.assistant.controller;

import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.service.CallRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/call/")
public class CallRecordController {


    @Autowired
    CallRecordService callRecordService;

    @PostMapping("/syncRecords")
    public Map<String,Object> syncRecords(@RequestBody List<CallRecord> callRecord){


        boolean flag= callRecordService.syncCallRecordsFromMobileToSystem(callRecord);

        Map<String, Object> resultMap = new HashMap<String, Object>();

        if (flag){
            resultMap.put("msg", "操作成功");
            resultMap.put("code", 0);
            resultMap.put("data", null);
        }

        return resultMap;



    }


}
