package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.service.CallBehaviorRealTimeService;
import com.rongzi.assistant.service.CallRecordService;
import com.rongzi.assistant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CallRecordServiceImpl implements CallRecordService {


    @Autowired
    CallRecordService callRecordService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CallBehaviorRealTimeService callBehaviorRealTimeService;


    @Override
    public boolean syncCallRecordsFromMobileToSystem(List<CallRecord> callRecords) {
        List<CallRecord> customerData = new ArrayList<CallRecord>();
        List<CallRecord> callBehaviorData = new ArrayList<CallRecord>();
        for (CallRecord callRecord : callRecords) {
            int callStatus = callRecord.getCallStatus();
            if (callStatus == 1 || callStatus == 2) {
                customerData.add(callRecord);
                callRecord.setSrc(callRecord.getEmpCode().substring(2, callRecord.getEmpCode().length()));
                callRecord.setDst(callRecord.getMobile());
            }
            if (callStatus == 3 || callStatus == 4) {
                callRecord.setSrc(callRecord.getMobile());
                callRecord.setDst(callRecord.getEmpCode().substring(2, callRecord.getEmpCode().length()));
            }
            callBehaviorData.add(callRecord);
        }
        if(customerData.size()>0){
            customerService.syncContactStatusByCallRecords(customerData);
        }
        callBehaviorRealTimeService.addCallBehaviorFromMobileToSystme(callBehaviorData);
        return true;
    }
}
