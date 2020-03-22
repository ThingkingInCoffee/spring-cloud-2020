package com.hzy.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRibbonRule {

    @Bean
    public IRule customRandomRule(){
        return new RandomRule();
    }

}
