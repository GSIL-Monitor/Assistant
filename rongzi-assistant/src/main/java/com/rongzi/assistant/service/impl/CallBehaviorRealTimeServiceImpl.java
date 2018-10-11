package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.common.datasource.AssistantDataSource;
import com.rongzi.assistant.common.datasource.AssistantDatasourceEnum;
import com.rongzi.assistant.dao.CallBehaviorMapper;
import com.rongzi.assistant.model.CallRecord;
import com.rongzi.assistant.service.CallBehaviorRealTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CallBehaviorRealTimeServiceImpl implements CallBehaviorRealTimeService {

    @Autowired
    CallBehaviorMapper callBehaviorMapper;

    /**
     * 批量增加通话记录
     *
     * @param callRecords
     * @return
     */
    @Override
    @AssistantDataSource(name = AssistantDatasourceEnum.DATA_SOURCE_CITY)
    public boolean addCallBehaviorFromMobileToSystme(List<CallRecord> callRecords) {
        int batchCount = 50;
        List<CallRecord> temp = new ArrayList<CallRecord>();
        for (int i = 0; i < callRecords.size(); i++) {
            temp.add(callRecords.get(i));
            if (i % batchCount == 0 && i > 0) {
                callBehaviorMapper.addCallBehaviorFromMobileToSystme(temp);
                temp.clear();
            }
        }

        return callBehaviorMapper.addCallBehaviorFromMobileToSystme(callRecords);
    }

}
