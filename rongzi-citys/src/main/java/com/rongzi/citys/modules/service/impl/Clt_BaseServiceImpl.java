package com.rongzi.citys.modules.service.impl;

import com.rongzi.citys.modules.dao.Clt_BaseDao;
import com.rongzi.citys.modules.model.Clt_base;
import com.rongzi.citys.modules.service.Clt_BaseService;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Clt_BaseServiceImpl implements Clt_BaseService {


    @Autowired
    Clt_BaseDao clt_baseDao;

    @Override
    public List<Clt_base> findClt_baseByCityTag(String CityTag) {

        DataSourceContextHolder.setDataSourceType(CityTag);

        return clt_baseDao.findClt_baseByCitys();
    }
}
