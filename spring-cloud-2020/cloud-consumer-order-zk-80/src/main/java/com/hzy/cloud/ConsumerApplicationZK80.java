package com.hzy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplicationZK80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplicationZK80.class, args);
    }

}
