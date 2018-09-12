package com.rongzi.assistant.service;

import com.rongzi.assistant.model.CallRecord;

import java.util.Date;
import java.util.List;

public interface CallRecordService {
    Date syncCallRecordsFromMobileToSystem(List<CallRecord> callRecords);
}
