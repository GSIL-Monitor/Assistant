package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.dao.CityMapper;
import com.rongzi.assistant.model.City;
import com.rongzi.assistant.service.CityService;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {


    @Autowired
    CityMapper cityDao;

    /**
     * 获取所有的城市列表
     * @return
     */
    @Override
    public List<City> findAllCitys() {

        DataSourceContextHolder.setDataSourceType("product");

        return cityDao.queryAllCitys();
    }
}
