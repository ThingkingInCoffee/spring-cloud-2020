package com.hzy.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalance {

    ServiceInstance instances(List<ServiceInstance> list);

}
