package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.common.exception.AssistantExceptionEnum;
import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.model.MobileDataSyncInfo;
import com.rongzi.assistant.service.CallBehaviorRealTimeService;
import com.rongzi.assistant.service.CallRecordService;
import com.rongzi.assistant.service.CustomerService;
import com.rongzi.assistant.service.MobileDataSnycInfoService;
import com.rongzi.core.exception.GunsException;
import com.rongzi.core.support.DateTimeKit;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CallRecordServiceImpl implements CallRecordService {

    private Logger logger = LoggerFactory.getLogger(CallRecordServiceImpl.class);

    @Autowired
    CallRecordService callRecordService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CallBehaviorRealTimeService callBehaviorRealTimeService;


    @Autowired
    MobileDataSnycInfoService mobileDataSnycInfoService;



    AtomicInteger integer=new AtomicInteger();

    /**
     * 从手机获取通话记录同步到系统
     *
     * @Author xulei
     * @Date 18:31 2018/10/12
     * @Param [callRecords]
     * @return java.util.Date
     **/
    @Override
    public Date syncCallRecordsFromMobileToSystem(List<CallRecord> callRecords) {


        String empCode = null;
        Date lowCallDate = null;
        Date highCallDate = null;
        List<CallRecord> currectRecord = new ArrayList<>();
        if (callRecords.size() >0) {
            for (int i = 0; i < callRecords.size(); i++) {
                if (!(StringUtils.isEmpty(callRecords.get(i).getMobile()) || (callRecords.get(i).getMobile().equals("null")))) {
                    currectRecord.add(callRecords.get(i));
                }
            }
        }

        if (currectRecord.size() >0) {
            for (int i = 0; i < currectRecord.size(); i++) {
                if (currectRecord.get(i).getMobile() != null) {
                    if (currectRecord.get(i).getMobile().startsWith("+86")) {
                        String newMobile = currectRecord.get(i).getMobile().substring(3, currectRecord.get(i).getMobile().length());
                        currectRecord.get(i).setMobile(newMobile);
                    }
                }
            }
            empCode = currectRecord.get(currectRecord.size() - 1).getEmpCode();
            lowCallDate = currectRecord.get(currectRecord.size() - 1).getCallDate();
            highCallDate = currectRecord.get(0).getCallDate();
        } else {
            throw new GunsException(AssistantExceptionEnum.REQUESTDATA_NULL);
        }
        logger.info("通话  传入过来的通话记录最大的时间是：" + highCallDate+ " 毫秒数目是：" + highCallDate.getTime());
        logger.info("通话  传入过来的通话记录的最小时间是：" + lowCallDate + " 毫秒数目是：" + lowCallDate.getTime());
        MobileDataSyncInfo dataSyncInfo = mobileDataSnycInfoService.findLastTime(empCode);
        if (dataSyncInfo != null) {
            Date lastCallRecordSyncTime = dataSyncInfo.getLastCallRecordSyncTime();
            if (lastCallRecordSyncTime != null) {
                logger.info("通话  数据库里面通话记录保存的最后时间是：" + lastCallRecordSyncTime + "毫秒数目是：" + lastCallRecordSyncTime.getTime());
                if (lastCallRecordSyncTime.getTime() >= (lowCallDate.getTime())) {
                    logger.info("通话  数据库保存的最后时间大于等于传入过来的最小时间,所以返回数据库里时间： " + lastCallRecordSyncTime);
                    logger.info("通话  无效的请求次数为： "+integer.addAndGet(1));
                    return lastCallRecordSyncTime;
                }
            }
        }
        List<CallRecord> customerData = new ArrayList<CallRecord>();
        List<CallRecord> callBehaviorData = new ArrayList<CallRecord>();
        for (CallRecord callRecord : currectRecord) {
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

        highCallDate= DateTimeKit.offsiteDate(highCallDate, Calendar.MILLISECOND,3);

        mobileDataSnycInfoService.syncSmsMessageAndCallRecordInfo(new MobileDataSyncInfo(empCode, null, highCallDate, new Date()));
        logger.info("通话  记录返回的时间数据是： " + highCallDate);
        return highCallDate;
    }

}
