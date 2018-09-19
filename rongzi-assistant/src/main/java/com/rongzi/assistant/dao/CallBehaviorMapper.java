package com.rongzi.assistant.dao;

import com.rongzi.assistant.model.CallRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CallBehaviorMapper {

    /**
     * @Author
     * @Description 增加手机通话记录到系统
     * @Date 14:08 2018/9/19
     * @Param [callRecords]
     * @return boolean
     **/
    boolean addCallBehaviorFromMobileToSystme(@Param("callRecords") List<CallRecord> callRecords);
}
