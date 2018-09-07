package com.rongzi.config.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "city")
public class CitysDataSourceConfig {


    private Map<String, CityDataSourceModel> map = new HashMap<String, CityDataSourceModel>();


    public Map<String, CityDataSourceModel> getMap() {
        return map;
    }

    public void setMap(Map<String, CityDataSourceModel> map) {
        this.map = map;
    }
}
