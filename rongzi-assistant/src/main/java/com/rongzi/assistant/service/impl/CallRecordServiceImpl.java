package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.model.MobileDataSyncInfo;
import com.rongzi.assistant.service.CallBehaviorRealTimeService;
import com.rongzi.assistant.service.CallRecordService;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.assistant.service.MobileDataSnycInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Highlighter;
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

        String empCode = null;
        Date lowCallDate = null;
        Date HighCallDate = null;
        if (callRecords.size() >= 1) {
            empCode = callRecords.get(callRecords.size() - 1).getEmpCode();
            HighCallDate  = callRecords.get(callRecords.size() - 1).getCallDate();
            lowCallDate= callRecords.get(0).getCallDate();
        }
        MobileDataSyncInfo dataSyncInfo = mobileDataSnycInfoService.findLastTime(empCode);
        if (dataSyncInfo != null) {
            if(dataSyncInfo.getLastCallRecordSyncTime()!=null){
                if (dataSyncInfo.getLastCallRecordSyncTime().getTime()>=(lowCallDate.getTime())) {
                    return dataSyncInfo.getLastCallRecordSyncTime();
                }
            }
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
        mobileDataSnycInfoService.syncSmsMessageAndCallRecordInfo(new MobileDataSyncInfo(empCode, null, HighCallDate, new Date()));

        return HighCallDate;
    }

}
