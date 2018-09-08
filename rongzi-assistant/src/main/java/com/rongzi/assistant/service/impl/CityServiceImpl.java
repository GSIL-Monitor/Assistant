package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.dao.CityMapper;
import com.rongzi.assistant.model.City;
import com.rongzi.assistant.service.CityService;
import com.rongzi.assistant.common.datasource.CityDataSource;
import com.rongzi.assistant.common.datasource.CityDatasourceEnum;
import com.rongzi.assistant.common.cache.Cache;
import com.rongzi.assistant.common.cache.CacheKey;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {


    @Autowired
    CityMapper cityDao;

    /**
     * 获取所有的城市列表
     *
     * @return
     */
    @Override
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.CITYS_NAME + "'")
    @CityDataSource(name = CityDatasourceEnum.DATA_SOURCE_PRODUCT)
    public List<City> findAllCitys() {
        List<City> cities = cityDao.queryAllCitys();
        return cities;
    }
}
