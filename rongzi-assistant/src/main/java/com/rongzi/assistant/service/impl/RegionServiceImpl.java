package com.rongzi.assistant.service.impl;

import com.rongzi.assistant.common.constant.cache.Cache;
import com.rongzi.assistant.common.constant.cache.CacheKey;
import com.rongzi.assistant.common.datasource.AssistantDataSource;
import com.rongzi.assistant.common.datasource.DatasourceEnum;
import com.rongzi.assistant.dao.CityMapper;
import com.rongzi.assistant.model.City;
import com.rongzi.assistant.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    CityMapper cityDao;

    /**
     * 获取所有的城市列表
     *
     * @return
     */
    @Override
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.CITY_NAME + "'")
    @AssistantDataSource(name = DatasourceEnum.DATA_SOURCE_PRODUCT)
    public List<City> findAllCities() {
        List<City> cities = cityDao.queryAllCitys();
        return cities;
    }

}
