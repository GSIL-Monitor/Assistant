package com.rongzi.assistant.service.impl;

import com.alibaba.fastjson.JSON;
import com.rongzi.AssistantApp;
import com.rongzi.assistant.model.City;
import com.rongzi.assistant.service.RegionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssistantApp.class)
public class RegionServiceImplTest {

    @Autowired
    RegionService regionService;

    @Test
    public void findAllCities() {
//        DataSourceContextHolder.setDataSourceType(DatasourceEnum.DATA_SOURCE_PRODUCT);
        List<City> cities = regionService.findAllCities();
        Map<Integer, String> map = cities.stream().collect(Collectors.toMap(City::getCityID, City::getCityName));
        System.out.println(JSON.toJSONString(map));
    }

}