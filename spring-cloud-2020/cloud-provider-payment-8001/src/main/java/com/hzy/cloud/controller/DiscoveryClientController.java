package com.hzy.cloud.controller;

import com.hzy.cloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试  Discovery Client
 */
@Slf4j
@RestController
public class DiscoveryClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/discovery/list")
    public CommonResult getServiceList(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service name is {}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info("instance serviceId is {}, instanceId is {}, host is {}, port is {}, uri is {}",instance.getServiceId(),instance.getInstanceId(),instance.getHost(),instance.getPort(),instance.getUri());
        }
        return new CommonResult(0000,"success", instances);
    }


}
