package com.hzy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix    /*开启服务降级*/
@EnableFeignClients
@SpringBootApplication
public class ConsumerFeignHystrixApplication80 {

    //方式一  参照服务端 通过  注解添加@HystrixCommand  注解通过  handler 处理方法
    //方式二  controller 层@DefaultProperties添加 全局handler  处理方法统一处理
    //方式三  feign service 接口的fallback属性设置降级处理类

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrixApplication80.class, args);
    }

}
