package com.rongzi.assistant.service;

import com.rongzi.assistant.model.CallRecord;

import java.util.List;

public interface CallRecordService {
    boolean syncCallRecordsFromMobileToSystem(List<CallRecord> callRecords);
}
