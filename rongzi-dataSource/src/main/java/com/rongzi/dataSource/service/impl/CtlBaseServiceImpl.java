package com.rongzi.dataSource.service.impl;

import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import com.rongzi.dataSource.dao.CltBaseMapper;
import com.rongzi.dataSource.model.CltBase;
import com.rongzi.dataSource.service.CtlBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CtlBaseServiceImpl implements CtlBaseService {


    @Autowired
    CltBaseMapper cltBaseMapper;


    @Override
    public List<CltBase> findCltBaseAll(String datasourceName) {

        DataSourceContextHolder.setDataSourceType(datasourceName);

        return cltBaseMapper.queryCltBaseAll();
    }
}
