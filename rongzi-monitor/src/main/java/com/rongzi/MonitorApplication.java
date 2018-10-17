package com.rongzi;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAdminServer
public class MonitorApplication {

    public static void main(String[] args) {

        SpringApplication.run(MonitorApplication.class, args);
    }

}
