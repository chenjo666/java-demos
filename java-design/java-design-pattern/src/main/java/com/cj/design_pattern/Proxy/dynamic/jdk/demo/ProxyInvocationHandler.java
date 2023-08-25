package com.cj.design_pattern.Proxy.dynamic.jdk.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;
    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }
    public void askForHelp() {
        System.out.println("提供咨询服务！");
    }
    public void freeHeadset() {
        System.out.println("赠送蓝牙耳机！");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        askForHelp();
        Object object = method.invoke(target, args);
        freeHeadset();
        return object;
    }
}
