package com.rongzi.hr.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = RongziProperties.PREFIX)
public class RongziProperties {

    public static final String PREFIX = "rongzi";

    private String catUrl;
    private String zabbixUrl;

    public String getCatUrl() {
        return catUrl;
    }

    public void setCatUrl(String catUrl) {
        this.catUrl = catUrl;
    }

    public String getZabbixUrl() {
        return zabbixUrl;
    }

    public void setZabbixUrl(String zabbixUrl) {
        this.zabbixUrl = zabbixUrl;
    }
}

