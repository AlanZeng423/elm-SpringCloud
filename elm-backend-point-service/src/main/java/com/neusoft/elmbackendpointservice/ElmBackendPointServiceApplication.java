package com.neusoft.elmbackendpointservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan({"com.neusoft.elmbackendpointservice.mapper"})
@ComponentScan("com.neusoft")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableDiscoveryClient
public class ElmBackendPointServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElmBackendPointServiceApplication.class, args);
    }

}
