package com.cj.enums;

public enum SmsTypeEnum {
    ALIBABA("alibaba"),
    TENCENT("tencent");
    private final String type;
    public String getType() {
        return type;
    }
    SmsTypeEnum(String type) {
        this.type = type;
    }
}
