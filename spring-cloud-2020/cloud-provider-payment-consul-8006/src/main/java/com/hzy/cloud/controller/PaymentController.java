package com.hzy.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentZookeeper(){
        String uuid = UUID.randomUUID().toString();
        log.info("spring cloud with consul server port is {}, uid is {}",serverPort, uuid);
        return  "success"+ serverPort + "==" + uuid;
    }
}
