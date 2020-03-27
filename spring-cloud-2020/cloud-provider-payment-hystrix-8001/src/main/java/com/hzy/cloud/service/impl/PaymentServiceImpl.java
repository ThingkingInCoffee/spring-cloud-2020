package com.hzy.cloud.service.impl;

import com.hzy.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    //服务降级

    @Override
    public String paymentInfoOk(Integer id) {
        return "this thread is "+ Thread.currentThread().getName()+"    payment timeout, id"+ id+ "    time is ok";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        int timeout = 5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "this thread is "+ Thread.currentThread().getName()+"    payment timeout, id"+ id+ "    time is "+ timeout;
    }

    //服务熔断


    @Override
    @HystrixCommand(fallbackMethod = "breakerHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  //失败率
    })
    public String paymentInfoBreaker(Integer id) {
        if (id < 0){
            throw new RuntimeException("不能为负数");
        }
        return UUID.randomUUID().toString();
    }

    public String breakerHandler(Integer id){
        return "不能为负数，稍后再试";
    }

}
