package com.hzy.cloud.controller;

import com.hzy.cloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderConsumerController {

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk/get")
    public CommonResult getResult(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk",CommonResult.class);
    }


}
