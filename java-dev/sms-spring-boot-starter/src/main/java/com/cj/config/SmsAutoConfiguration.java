package com.cj.config;

import com.cj.properties.SmsProperties;
import com.cj.service.SmsService;
import com.cj.service.SmsTemplate;
import com.cj.service.impl.AlibabaSmsServiceImpl;
import com.cj.service.impl.TencentSmsServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(SmsTemplate.class)
@EnableConfigurationProperties(value = SmsProperties.class)
public class SmsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SmsTemplate smsTemplate(SmsProperties smsProperties){
        return new SmsTemplate(smsProperties);
    }

    @Bean
    public SmsService alibaba() {
        return new AlibabaSmsServiceImpl();
    }

    @Bean
    public SmsService tencent() {
        return new TencentSmsServiceImpl();
    }

}
