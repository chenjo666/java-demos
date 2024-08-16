package com.example.javadevspringboot.controller;

import com.example.javadevspringboot.dto.BaseResponse;
import com.example.javadevspringboot.dto.ValidateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjian
 * @datetime 2024-08-16 20:21
 */
@RestController
public class ParamController {

    @PostMapping("/param")
    public BaseResponse param(@RequestBody ValidateRequest request) {
        return BaseResponse.success();
    }
}
