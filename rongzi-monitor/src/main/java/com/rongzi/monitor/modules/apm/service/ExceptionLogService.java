package com.rongzi.monitor.modules.apm.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.rongzi.monitor.modules.apm.model.ExceptionLog;

import java.util.List;
import java.util.Map;

public interface ExceptionLogService extends IService<ExceptionLog> {

    List<Map<String, Object>> getExceptionLogsAll(String beginTime, String endTime, Integer systemCode, Integer isReadonly, Page<ExceptionLog> page, String Owner, Integer Status,String orderByField, boolean asc);

    boolean multiUpdateLogByIdAndOccurTime(int id, String time, String Owner, Integer Status);

    List<ExceptionLog> findAllExceptionLogsForDownLoad(String beginTime, String endTime, Integer systemCode, Integer isReadonly, String Owner, Integer Status);
}
