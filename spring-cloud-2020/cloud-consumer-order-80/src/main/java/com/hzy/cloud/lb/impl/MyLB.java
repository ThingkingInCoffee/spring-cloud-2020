package com.hzy.cloud.lb.impl;

import com.hzy.cloud.lb.MyLoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements MyLoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("访问次数 next is ===== "+ next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> list) {
        int index = getAndIncrement() % list.size();
        return list.get(index);
    }
}
