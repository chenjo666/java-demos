package com.cj.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {
    @Bean
    public Logger.Level loglevel() {
        return Logger.Level.BASIC;
    }
}
