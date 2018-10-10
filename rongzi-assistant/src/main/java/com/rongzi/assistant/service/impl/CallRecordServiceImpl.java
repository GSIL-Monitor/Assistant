package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.common.exception.AssistantExceptionEnum;
import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.model.MobileDataSyncInfo;
import com.rongzi.assistant.service.CallBehaviorRealTimeService;
import com.rongzi.assistant.service.CallRecordService;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.assistant.service.MobileDataSnycInfoService;
import com.rongzi.core.exception.GunsException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Highlighter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CallRecordServiceImpl implements CallRecordService {

    private Logger logger= LoggerFactory.getLogger(CallRecordServiceImpl.class);

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
        Date highCallDate = null;
        if (callRecords.size() >= 1) {
            for(int i=0;i<callRecords.size();i++){
                if(StringUtils.isEmpty(callRecords.get(i).getMobile()) || (callRecords.get(i).getMobile() .equals("null"))){
                    callRecords.remove(callRecords.get(i));
                    continue;
                }
            }
            if(callRecords.size() >= 1){
                empCode = callRecords.get(callRecords.size() - 1).getEmpCode();
                lowCallDate  = callRecords.get(callRecords.size() - 1).getCallDate();
                highCallDate= callRecords.get(0).getCallDate();
            }else{
                throw new GunsException(AssistantExceptionEnum.REQUESTDATA_NULL);
            }
        }else {
           throw new GunsException(AssistantExceptionEnum.REQUESTDATA_NULL);
        }
        logger.info("通话记录最大的时间数据是："+highCallDate);
        logger.info("通话记录最小的时间数据是："+lowCallDate);
        MobileDataSyncInfo dataSyncInfo = mobileDataSnycInfoService.findLastTime(empCode);
        if (dataSyncInfo != null) {
            if(dataSyncInfo.getLastCallRecordSyncTime()!=null){
                logger.info("通话  数据库里面保存的时间是："+dataSyncInfo.getLastCallRecordSyncTime()+"毫秒数目是："+dataSyncInfo.getLastCallRecordSyncTime().getTime());
                logger.info("通话  传入过来的通话时间是："+lowCallDate+" 毫秒数目是："+lowCallDate.getTime());
                if (dataSyncInfo.getLastCallRecordSyncTime().getTime()>=(lowCallDate.getTime())) {
                    logger.info("通话  数据库时间大于等于最小时间,所以返回： "+dataSyncInfo.getLastCallRecordSyncTime());
                    Date lastCallRecordSyncTime = dataSyncInfo.getLastCallRecordSyncTime();
                    return lastCallRecordSyncTime;
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

        mobileDataSnycInfoService.syncSmsMessageAndCallRecordInfo(new MobileDataSyncInfo(empCode, null, highCallDate, new Date()));
        logger.info("通话  记录返回的时间数据是： "+highCallDate);
        return highCallDate;
    }

}
