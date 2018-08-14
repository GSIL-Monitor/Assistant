package com.rongzi.log;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.rongzi.demo.modules.sql.dao")
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class,args);
    }

}
