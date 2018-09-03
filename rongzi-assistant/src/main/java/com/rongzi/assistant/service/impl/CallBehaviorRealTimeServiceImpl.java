package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.common.context.UserContextHolder;
import com.rongzi.assistant.dao.CallBehaviorMapper;
import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.model.UserInfo;
import com.rongzi.assistant.service.CallBehaviorRealTimeService;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CallBehaviorRealTimeServiceImpl implements CallBehaviorRealTimeService {


    @Autowired
    CallBehaviorMapper callBehaviorMapper;


    @Override
    public boolean addCallBehaviorFromMobileToSystme(List<CallRecord> callRecords) {

        /**
         * 批量增加通话记录
         */
        UserInfo currentUser = UserContextHolder.getCurrentUserInfo();
        DataSourceContextHolder.setDataSourceType(currentUser.getCityCode());


        int batchCount = 100;
        List<CallRecord> temp = new ArrayList<CallRecord>();

        for (int i = 0; i < callRecords.size(); i++) {
            temp.add(callRecords.get(i));
            if (i % batchCount == 0 && i > 0) {
                callBehaviorMapper.addCallBehaviorFromMobileToSystme(temp);
                temp.clear();
            }
        }

        boolean flag = callBehaviorMapper.addCallBehaviorFromMobileToSystme(callRecords);

        DataSourceContextHolder.clearDataSourceType();

        return flag;
    }
}
