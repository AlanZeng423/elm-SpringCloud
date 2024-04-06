package com.neusoft.elmbackendcartservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan({"com.neusoft.elmbackendcartservice.mapper"})
@ComponentScan("com.neusoft")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableDiscoveryClient
public class ElmBackendCartServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElmBackendCartServiceApplication.class, args);
    }

}
