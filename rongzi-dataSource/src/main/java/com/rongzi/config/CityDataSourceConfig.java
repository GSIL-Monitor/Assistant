package com.rongzi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "city")
public class CityDataSourceConfig {


    private Map<String,DataSourceModel> map=new HashMap<String,DataSourceModel>();


    public Map<String, DataSourceModel> getMap() {
        return map;
    }

    public void setMap(Map<String, DataSourceModel> map) {
        this.map = map;
    }
}
