package com.rongzi.assistant.service.impl;

import com.alibaba.fastjson.JSON;
import com.rongzi.AssistantApp;
import com.rongzi.assistant.model.City;
import com.rongzi.assistant.service.CityService;
import com.rongzi.core.mutidatasource.DataSourceContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssistantApp.class)
public class CityServiceImplTest {



    @Autowired
    CityService cityService;

    @Test
    public void findAllCitys() {


        DataSourceContextHolder.setDataSourceType("product");

        List<City> citys = cityService.findAllCitys();

        Map<Integer, String> map = citys.stream().collect(Collectors.toMap(City::getCityID, City::getCityName));


        System.out.println(JSON.toJSONString(map));


    }
}