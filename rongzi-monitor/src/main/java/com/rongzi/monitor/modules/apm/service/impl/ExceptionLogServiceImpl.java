package com.rongzi.monitor.modules.apm.service.impl;

import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import com.rongzi.monitor.core.common.constant.DatasourceEnum;
import com.rongzi.monitor.modules.apm.dao.ExceptionLogMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.core.mutidatasource.annotion.DataSource;
import com.rongzi.monitor.modules.apm.model.ExceptionLog;
import com.rongzi.monitor.modules.apm.service.ExceptionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExceptionLogServiceImpl extends ServiceImpl<ExceptionLogMapper, ExceptionLog> implements ExceptionLogService {

    @Autowired
    private ExceptionLogMapper exceptionLogMapper;


    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_HISTORY)
    public List<Map<String, Object>> getExceptionLogsAll(String beginTime, String endTime, Integer systemCode, Integer isReadonly, Page<ExceptionLog> page, String Owner, Integer Status, String orderByField, boolean asc) {

        List<Map<String, Object>> data=exceptionLogMapper.findExceptionLogsAll(beginTime, endTime, systemCode, isReadonly, page, Owner, Status,orderByField,asc);
        return data;
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_HISTORY)
    public boolean multiUpdateLogByIdAndOccurTime(int id, String paramsDatum, String Owner, Integer Status) {
        return exceptionLogMapper.updateLogByIdAndOccurTime(id, paramsDatum, Owner, Status);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_HISTORY)
    public List<ExceptionLog> findAllExceptionLogsForDownLoad(String beginTime, String endTime, Integer systemCode, Integer isReadonly, String Owner, Integer Status) {


        return exceptionLogMapper.findExceptionLogsForExcelDownload(beginTime, endTime, systemCode, isReadonly, Owner, Status);
    }

    @Override
    public List<Map<String, Object>> getExceptionLogsAllByDatabase(String beginTime, String endTime, Integer systemCode, Integer isReadonly, Page<ExceptionLog> page, String Owner, Integer Status, String orderByField, boolean asc, String flag) {

        DataSourceContextHolder.setDataSourceType(flag);

        List<Map<String, Object>> data=exceptionLogMapper.findExceptionLogsAll(beginTime, endTime, systemCode, isReadonly, page, Owner, Status,orderByField,asc);

        return data;
    }

}
