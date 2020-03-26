package com.hzy.cloud.service;

import com.hzy.cloud.service.impl.PaymentFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {

    @GetMapping(value = "/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/payment/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable(value = "id") Integer id);
}
