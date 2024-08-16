package com.example.javadevspringboot.config;

import com.example.javadevspringboot.dto.BaseRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * @author chenjian
 * @datetime 2024-08-16 20:20
 */

@Aspect
@Component
public class ValidationAspect {

    @Around("execution(* com.example.javadevspringboot.controller..*(..))")
    public Object aroundControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取方法参数
        Object[] args = joinPoint.getArgs();

        // 遍历参数并调用 validate() 方法
        for (Object arg : args) {
            if (arg instanceof BaseRequest request) {
                request.validate(); // 调用 validate 方法
            }
        }

        // 继续执行原方法
        return joinPoint.proceed();
    }
}

