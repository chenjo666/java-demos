package com.cj.design_pattern.Proxy.dynamic.jdk.template;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    // target: 目标对象
    private Object target;
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    public void before() {
    }
    public void after() {
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(this.target, args);
        after();
        return object;
    }
}
