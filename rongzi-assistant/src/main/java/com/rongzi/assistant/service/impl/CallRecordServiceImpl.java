package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.model.MobileDataSyncInfo;
import com.rongzi.assistant.service.CallBehaviorRealTimeService;
import com.rongzi.assistant.service.CallRecordService;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.assistant.service.MobileDataSnycInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CallRecordServiceImpl implements CallRecordService {

    @Autowired
    CallRecordService callRecordService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CallBehaviorRealTimeService callBehaviorRealTimeService;


    @Autowired
    MobileDataSnycInfoService mobileDataSnycInfoService;

    @Override
    public Date syncCallRecordsFromMobileToSystem(List<CallRecord> callRecords) {

        String empCode=null;
        Date callDate=null;
        if(callRecords.size()>=1){
            CallRecord callRecord = callRecords.get(callRecords.size() - 1);
            empCode = callRecord.getEmpCode();
            callDate=callRecord.getCallDate();
        }

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
        if (customerData.size() > 0) {
            customerService.syncContactStatusByCallRecords(customerData);
        }
        callBehaviorRealTimeService.addCallBehaviorFromMobileToSystme(callBehaviorData);
        mobileDataSnycInfoService.syncSmsMessageAndCallRecordInfo(new MobileDataSyncInfo(empCode,null,callDate,new Date()));
        return callDate;
    }

}
