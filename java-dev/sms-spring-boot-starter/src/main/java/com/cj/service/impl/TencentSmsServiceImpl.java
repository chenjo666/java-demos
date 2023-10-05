package com.cj.service.impl;

import com.cj.service.SmsService;

public class TencentSmsServiceImpl implements SmsService {
    @Override
    public String send(String fromPhone, String toPhone, String content) {
        return fromPhone + "使用【Tencent SMS】向" + toPhone + "发送一条短信：" + content;
    }
}
