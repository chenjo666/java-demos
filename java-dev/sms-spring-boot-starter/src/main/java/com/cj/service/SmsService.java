package com.cj.service;

public interface SmsService {
    String send(String fromPhone, String toPhone, String content);
}

