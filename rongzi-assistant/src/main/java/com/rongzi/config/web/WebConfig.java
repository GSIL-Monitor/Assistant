package com.rongzi.config.web;

import com.rongzi.assistant.common.web.filter.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean authFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        AuthFilter filter = new AuthFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }

}
