package com.cj.properties;

import com.cj.enums.SmsTypeEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sms.service")
public class SmsProperties {

    private boolean enable = true;
    private String type = SmsTypeEnum.ALIBABA.getType();

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

