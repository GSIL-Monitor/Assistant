package com.rongzi.monitor.modules.apm.service.impl;

import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import com.rongzi.monitor.core.common.constant.DatasourceEnum;
import com.rongzi.monitor.modules.apm.dao.ExceptionLogMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.core.mutidatasource.annotion.DataSource;
import com.rongzi.monitor.modules.apm.model.ExceptionLog;
import com.rongzi.monitor.modules.apm.service.ExceptionLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExceptionLogServiceImpl extends ServiceImpl<ExceptionLogMapper, ExceptionLog> implements ExceptionLogService {

    private Logger logger= LoggerFactory.getLogger(ExceptionLogServiceImpl.class);

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

        Long time=System.currentTimeMillis();

        DataSourceContextHolder.setDataSourceType(flag);

        Long time1=System.currentTimeMillis();
        List<Map<String, Object>> data=exceptionLogMapper.findExceptionLogsAll(beginTime, endTime, systemCode, isReadonly, page, Owner, Status,orderByField,asc);
        Long time2=System.currentTimeMillis();

        DataSourceContextHolder.clearDataSourceType();
        Long time3=System.currentTimeMillis();

        logger.info("包含数据源切换在内的总毫秒数目为："+(time3-time));
        logger.info("单纯SQL执行消耗时间为："+(time2-time1));

        return data;
    }

}
