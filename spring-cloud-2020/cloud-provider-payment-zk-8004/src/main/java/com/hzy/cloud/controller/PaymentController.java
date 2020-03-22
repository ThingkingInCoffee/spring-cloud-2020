package com.hzy.cloud.controller;

import com.hzy.cloud.entities.CommonResult;
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

    @GetMapping(value = "/payment/zk")
    public CommonResult paymentZookeeper(){
        String uuid = UUID.randomUUID().toString();
        log.info("spring cloud with zookeeper server port is {}, uid is {}",serverPort, uuid);
        return new CommonResult(0000, "success", serverPort + "==" + uuid);
    }
}
