package com.rongzi.assistant.dao;

import com.rongzi.assistant.model.MobileDataSyncInfo;

public interface MobileDataSyncMapper {

    int updateSyncInfo(MobileDataSyncInfo mobileDataSyncInfo);

    void insertSyncInfo(MobileDataSyncInfo mobileDataSyncInfo);
}
