package com.rongzi.monitor.modules.apm.service.impl;

import com.rongzi.monitor.core.common.constant.DatasourceEnum;
import com.rongzi.monitor.modules.apm.dao.SysExceptionMapper;
import com.rongzi.monitor.modules.apm.model.SysException;
import com.rongzi.monitor.modules.apm.service.SysExceptionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.core.mutidatasource.annotion.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class SysExceptionServiceImpl extends ServiceImpl<SysExceptionMapper, SysException> implements SysExceptionService {

    @Autowired
    private SysExceptionMapper sysExceptionMapper;

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> getSysExceptionsAllByOccurDate(String OccurDate) {
        List<Map<String, Object>> result= sysExceptionMapper.findSysExceptionAllByOccurDate(OccurDate);
        return result;
    }

}
