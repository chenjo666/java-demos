package com.example.javadevspringboot.config;


import com.example.javadevspringboot.dto.BaseResponse;
import com.example.javadevspringboot.expection.BizException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chenjian
 * @datetime 2024-08-12 21:56
 */
@RestControllerAdvice("com.example.javadevspringboot.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class})
    public String handleException(Exception e) {
        e.printStackTrace();
        return "exception";
    }
    @ExceptionHandler({BizException.class})
    public BaseResponse handleException(BizException e) {
        return BaseResponse.fail();
    }



    // feign 如果调用异常，会抛出什么异常？

    // 1. FeignException：Feign调用失败，比如网络异常、超时、服务端返回错误等。
    // 2. FeignException.BadRequest：Feign调用失败，服务端返回400错误。
    // 3. FeignException.InternalServerError：Feign调用失败，服务端返回500错误。
    // 4. FeignException.NotFound：Feign调用失败，服务端返回404错误。
    // 5. FeignException.MethodNotAllowed：Feign调用失败，服务端返回405错误。
}
