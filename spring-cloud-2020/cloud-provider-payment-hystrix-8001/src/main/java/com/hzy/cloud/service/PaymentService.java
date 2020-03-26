package com.hzy.cloud.service;

public interface PaymentService {
    //服务降级
    String paymentInfoOk(Integer id);

    String paymentInfoTimeout(Integer id);

    //服务熔断
    String paymentInfoBreaker(Integer id);
}
