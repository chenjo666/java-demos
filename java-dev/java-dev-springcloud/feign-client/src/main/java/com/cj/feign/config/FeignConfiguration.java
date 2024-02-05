package com.cj.feign.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {
    @Bean
    public Logger.Level loglevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public RequestInterceptor userInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.header("user", "123");
            }
        };
    }
}
