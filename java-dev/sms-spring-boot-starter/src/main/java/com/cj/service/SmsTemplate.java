package com.cj.service;

import com.cj.properties.SmsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class SmsTemplate {
    private SmsProperties smsProperties;
    public SmsTemplate(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
    }
    @Autowired
    private ApplicationContext context;

//    public String send(String fromPhone, String toPhone, String content) {
//        if (!smsProperties.isEnable()) {
//            throw new RuntimeException("操作失败！请先开启邮件服务");
//        }
//        String type = smsProperties.getType();
//        SmsService smsService = context.getBean(type, SmsService.class);
//        return smsService.send(fromPhone, toPhone, content);
//    }
}
