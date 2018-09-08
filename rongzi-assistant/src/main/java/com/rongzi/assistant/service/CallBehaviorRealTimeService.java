package com.rongzi.assistant.service;

import com.rongzi.assistant.model.CallRecord;

import java.util.List;

public interface CallBehaviorRealTimeService {
    boolean addCallBehaviorFromMobileToSystme(List<CallRecord> callRecords);
}
