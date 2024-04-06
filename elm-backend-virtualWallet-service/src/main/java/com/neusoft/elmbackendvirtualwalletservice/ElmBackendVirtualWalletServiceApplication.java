package com.neusoft.elmbackendvirtualwalletservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan({"com.neusoft.elmbackendvirtualwalletservice.mapper"})
@ComponentScan("com.neusoft")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableDiscoveryClient
public class ElmBackendVirtualWalletServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElmBackendVirtualWalletServiceApplication.class, args);
    }

}
