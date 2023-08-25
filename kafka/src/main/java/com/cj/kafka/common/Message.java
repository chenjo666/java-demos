package com.cj.kafka.common;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Message {
    private int code;
    private String msg;
    private Object data;
}
