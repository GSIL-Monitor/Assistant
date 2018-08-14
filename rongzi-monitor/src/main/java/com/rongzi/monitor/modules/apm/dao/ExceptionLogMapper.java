package com.rongzi.monitor.modules.apm.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.rongzi.monitor.modules.apm.model.ExceptionLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ExceptionLogMapper extends BaseMapper<ExceptionLog> {

    /*
        获取系统的异常总数
     */
    int getExceptionSum();

    List<Map<String, Object>> findExceptionLogsAll(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("systemCode") Integer systemCode, @Param("isReadonly") Integer isReadonly, @Param("page") Page<ExceptionLog> page, @Param("Owner") String Owner, @Param("Status") Integer Status,@Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);

    boolean updateLogByIdAndOccurTime(@Param("id") int id, @Param("time") String time, @Param("Owner") String Owner, @Param("Status") Integer Status);

    List<ExceptionLog> findExceptionLogsForExcelDownload(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("systemCode") Integer systemCode, @Param("isReadonly") Integer isReadonly, @Param("Owner") String Owner, @Param("Status") Integer Status);
}