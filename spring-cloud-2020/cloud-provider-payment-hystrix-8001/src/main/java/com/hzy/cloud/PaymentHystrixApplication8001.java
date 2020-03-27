package com.hzy.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//设置开启回路，配合服务端降级@HystrixCommand使用
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class PaymentHystrixApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixApplication8001.class, args);
    }

    /**
     *  为服务监控而配置，与服务容错无关系，spring cloud 升级之后的坑
     *  HystrixMetricsStreamServlet 配置是因为spring boot 默认路径不是 /hystrix.stream
     *  在项目中配置上此 servlet 就行了
     *  官网建议： 添加  management.endpoints.web.exposure.include: hystrix.stream 即可  或者 *    暂未调通
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }


}
