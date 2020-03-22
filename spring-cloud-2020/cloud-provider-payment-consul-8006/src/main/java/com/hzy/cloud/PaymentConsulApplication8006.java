package com.hzy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentConsulApplication8006 {
    //启动注册成功后 在 consul 的 web 页面中可以查看到该服务
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulApplication8006.class, args);
    }

}
