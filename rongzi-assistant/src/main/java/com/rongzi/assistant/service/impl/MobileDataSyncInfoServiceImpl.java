package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.dao.MobileDataSyncMapper;
import com.rongzi.assistant.model.MobileDataSyncInfo;
import com.rongzi.assistant.service.MobileDataSnycInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileDataSyncInfoServiceImpl implements MobileDataSnycInfoService {

    @Autowired
    MobileDataSyncMapper mobileDataSyncMapper;

    @Override
    public void syncSmsMessageAndCallRecordInfo(MobileDataSyncInfo mobileDataSyncInfo) {

        int count= mobileDataSyncMapper.updateSyncInfo(mobileDataSyncInfo);
        if(count<=0){
            mobileDataSyncMapper.insertSyncInfo(mobileDataSyncInfo);
        }
    }
}
