package com.hzy.cloud.controller;

import com.hzy.cloud.entities.CommonResult;
import com.hzy.cloud.entities.Payment;
import com.hzy.cloud.lb.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class OrderConsumerController {

    //单机版本直接请求某个IP的服务，集群不合适
    //public static final String PROVIDER_PAYMENT_URL = "http://localhost:8001";
    //改为请求  服务注册名称
    //同时 ！！！
    // 因为服务会有多个，restTemplate 需要一个负载的规则，因此 restTemplate 配置上需要使用 @LoadBalanced  注解
    public static final String PROVIDER_PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    //引入自定义的 负载均衡测试
    @Resource
    private MyLoadBalance loadBalance;
    @Autowired
    private DiscoveryClient discoveryClient;


    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PROVIDER_PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PROVIDER_PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/test/lb")
    public String testLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() < 1) {
            return null;
        }
        ServiceInstance instance = loadBalance.instances(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/lb", String.class);
    }

}
