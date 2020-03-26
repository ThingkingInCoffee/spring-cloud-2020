package com.hzy.cloud.controller;

import com.hzy.cloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@DefaultProperties(defaultFallback = "globalHandler")
public class PaymentController {

    @Resource
    private PaymentFeignService paymentService;

    @GetMapping(value = "/consumer/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable Integer id) {
        return paymentService.paymentInfoOk(id);
    }

    @GetMapping(value = "/consumer/payment/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable Integer id) {
        return paymentService.paymentInfoTimeout(id);
    }

    /**
     *  全局降级处理方法  配合类级别注解    使用
     * @param id
     * @return
     */
    public String globalHandler(@PathVariable Integer id) {
        return "==========global  handler===========";
    }



}