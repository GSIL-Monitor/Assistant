package com.rongzi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = "com.rongzi.citys.modules.dao")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CitysApp {

    public static void main(String[] args) {


        SpringApplication.run(CitysApp.class,args);
    }
}
