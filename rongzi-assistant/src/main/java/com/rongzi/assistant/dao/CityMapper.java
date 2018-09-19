package com.rongzi.assistant.dao;

import com.rongzi.assistant.model.City;

import java.util.List;

public interface CityMapper {

    /**
     * @Author 
     * @Description 获取所有的城市列表
     * @Date 14:07 2018/9/19
     * @Param []
     * @return java.util.List<com.rongzi.assistant.model.City>
     **/
    List<City> queryAllCitys();

}
