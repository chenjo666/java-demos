package com.example.javadevspringboot.dto;

import lombok.Data;

/**
 * @author chenjian
 * @datetime 2024-08-16 20:22
 */
@Data
public class BaseResponse {
    private String retCode;
    private String retMsg;
    public static BaseResponse success() {
        BaseResponse response = new BaseResponse();
        response.setRetCode("0");
        response.setRetMsg("success");
        return response;
    }
    public static BaseResponse fail() {
        BaseResponse response = new BaseResponse();
        response.setRetCode("-1");
        response.setRetMsg("fail");
        return response;
    }
}
