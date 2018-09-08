package com.rongzi.assistant.dao;

import com.rongzi.assistant.model.CallRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CallBehaviorMapper {

    boolean addCallBehaviorFromMobileToSystme(@Param("callRecords") List<CallRecord> callRecords);

}
