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


        /**
         * 在同一个库的两张表中增加数据
         * 1：表 SAL_CLT_LNKMAN 客户编号  通话状态
         * 2：通话记录表  拨打者 接听者 通话时长  通话时间  同步时间 更新时间
         */
        /**
         *
         * 1：根据通话类型，如果是销售拨打客户，那就统计到客户接听类型然后增加到客户表里面
         * 根据 1 和 2 来进行，不是这2个的就不需要管理
         *
         * 2：根据通话类型，判断出接听者和拨打者，然后增加到通话记录表中
         * 1 2 那么拨打者就是销售  增加进去的数据顺序为： 工号  客户手机号
         * 3 4 拨打者就是客户   增加进去的数据顺序为： 客户手机号码 工号
         */

        //客户表数据
        List<CallRecord> customerData = new ArrayList<CallRecord>();

        //通话记录表数据
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

        boolean flag = customerService.syncContactStatusByCallRecords(customerData);
        boolean callBehaviorFlag = callBehaviorRealTimeService.addCallBehaviorFromMobileToSystme(callBehaviorData);

        if (flag && callBehaviorFlag) {

            return true;
        }
        return false;
    }
}
