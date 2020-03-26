package com.hzy.cloud.service.impl;

import com.hzy.cloud.service.PaymentFeignService;
import org.springframework.stereotype.Service;

@Service
public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "======fallback  property========";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "======fallback  property========";
    }
}
