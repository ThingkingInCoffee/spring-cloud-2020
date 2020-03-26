package com.hzy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConsumerFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign80.class, args);
    }

}
