package com.hzy.cloud.controller;

import com.hzy.cloud.entities.CommonResult;
import com.hzy.cloud.entities.Payment;
import com.hzy.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("==========={}=============",result);
        if (result > 0){
            return new CommonResult(0000,"success"+serverPort);
        } else {
            return new CommonResult(9999,"error"+serverPort);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("==========={}",result);
        if (result != null){
            return new CommonResult(0000,"success"+serverPort, result);
        } else {
            return new CommonResult(9999,"error"+serverPort, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String customLoadBalance(){
        return serverPort;
    }


    @GetMapping(value = "/payment/timeout")
    public String feignTestTimeout(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }



}
