package com.rongzi.monitor.modules.apm.service.impl;

import com.rongzi.monitor.core.common.constant.DatasourceEnum;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rongzi.core.mutidatasource.annotion.DataSource;
import com.rongzi.monitor.modules.apm.dao.DicSystemMapper;
import com.rongzi.monitor.modules.apm.dao.TypeExceptionMapper;
import com.rongzi.monitor.modules.apm.model.TypeException;
import com.rongzi.monitor.modules.apm.service.TypeExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TypeExceptionServiceImpl extends ServiceImpl<TypeExceptionMapper, TypeException> implements TypeExceptionService {

    @Autowired
    private  TypeExceptionMapper typeExceptionMapper;

    @Autowired
    private DicSystemMapper dicSystemMapper;

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> queryTypeExceptionsBySysNameAndOccurDate(String SysName, String OccurDate) {
        Integer code = dicSystemMapper.findSystemCodeBySystemName(SysName);
        List<Map<String, Object>> result = typeExceptionMapper.findTypeExceptionByCodeAndOccurDate(code, OccurDate);
        return result;
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> queryPageByServer(Page<TypeException> page, String SysName, String OccurDate, String orderByField, boolean asc) {
        Integer code = dicSystemMapper.findSystemCodeBySystemName(SysName);
        List<Map<String, Object>> result = typeExceptionMapper.findTypeExceptionByCodeAndOccurDatePage(page,code,OccurDate,orderByField,asc);
        return result;
    }

}
