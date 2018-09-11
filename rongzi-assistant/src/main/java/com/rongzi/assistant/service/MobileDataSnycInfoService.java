package com.rongzi.assistant.service;

import com.rongzi.assistant.model.MobileDataSyncInfo;

public interface MobileDataSnycInfoService {

    void  syncSmsMessageAndCallRecordInfo(MobileDataSyncInfo mobileDataSyncInfo);
}
