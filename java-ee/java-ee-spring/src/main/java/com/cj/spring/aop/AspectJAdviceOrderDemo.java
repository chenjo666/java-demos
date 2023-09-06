package com.cj.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
class AdviceOrder {
    public void output() {
        System.out.println("OUTPUT");
    }
}
@Component
@Aspect
class AspectjAdviceOrder {
    @Pointcut("execution(* com.cj.spring.aop.AdviceOrder.output(..))")
    public void point() {}

    @Before("point()")
    public void before() {
        System.out.println("before...");
    }
    @AfterReturning("point()")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }
    @After("point()")
    public void after() {
        System.out.println("after...");
    }
    @Around("point()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before...");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("around after...");
        return proceed;
    }
    @Before("point()")
    public void before2() {
        System.out.println("before2...");
    }
}

public class AspectJAdviceOrderDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        AdviceOrder adviceOrder = context.getBean("adviceOrder", AdviceOrder.class);
        adviceOrder.output();
    }
}
//around before...
//before...
//OUTPUT
//afterReturning...
//after...
//around after...