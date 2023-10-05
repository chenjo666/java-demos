package com.cj.service.impl;

import com.cj.service.SmsService;

public class AlibabaSmsServiceImpl implements SmsService {

    @Override
    public String send(String fromPhone, String toPhone, String content) {
        return fromPhone + "使用【Alibaba SMS】向" + toPhone + "发送一条短信：" + content;
    }
}

