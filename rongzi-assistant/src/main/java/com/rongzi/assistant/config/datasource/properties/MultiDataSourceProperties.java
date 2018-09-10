package com.rongzi.assistant.config.datasource.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "rongzi")
public class MultiDataSourceProperties {

    private Map<String, DataSourceModel> datasources = new HashMap<String, DataSourceModel>();

    public Map<String, DataSourceModel> getDatasources() {
        return datasources;
    }

    public void setDatasources(Map<String, DataSourceModel> datasources) {
        this.datasources = datasources;
    }
}
