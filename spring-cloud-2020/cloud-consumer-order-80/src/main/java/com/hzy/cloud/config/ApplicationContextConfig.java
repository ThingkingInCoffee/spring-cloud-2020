package com.hzy.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced         //测试自定义的 负载均衡，将此处注释掉
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
