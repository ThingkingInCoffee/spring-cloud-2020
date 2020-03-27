package com.hzy.cloud.controller;

import com.hzy.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable Integer id) {
        return paymentService.paymentInfoOk(id);
    }

    //服务提供方设置降级处理    设置属性，当前服务如果超过 2000毫秒会 降级处理
    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    @GetMapping(value = "/payment/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable Integer id) {
        return paymentService.paymentInfoTimeout(id);
    }

    public String timeoutHandler(@PathVariable Integer id) {
        return "==========handler===========";
    }

    //服务熔断
    @GetMapping(value = "/payment/breaker/{id}")
    public String paymentInfo(@PathVariable Integer id) {
        return paymentService.paymentInfoBreaker(id);
    }

}
