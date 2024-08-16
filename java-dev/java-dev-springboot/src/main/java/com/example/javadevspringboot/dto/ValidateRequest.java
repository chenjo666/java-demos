package com.example.javadevspringboot.dto;

import com.example.javadevspringboot.expection.BizAssert;
import lombok.Data;

/**
 * @author chenjian
 * @datetime 2024-08-16 20:27
 */
@Data
public class ValidateRequest extends BaseRequest {
    private String username;
    private String password;

    @Override
    public void validate() {
        BizAssert.isTrue(username != null, "用户名不能为空");
    }
}
