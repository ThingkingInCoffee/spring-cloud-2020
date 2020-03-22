package com.hzy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentApplicationZK8004 {

    //@EnableDiscoveryClient  用于 consul  或者 zookeeper 作为注册中心时使用

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationZK8004.class, args);
    }

}
