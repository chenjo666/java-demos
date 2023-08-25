package com.cj.design_pattern.Proxy.dynamic.cglib.demo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyMethodInterceptor implements MethodInterceptor {

    public void askForHelp() {
        System.out.println("提供咨询服务！");
    }
    public void freeHeadset() {
        System.out.println("赠送蓝牙耳机！");
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        askForHelp();
        Object object = methodProxy.invokeSuper(o, objects);
        freeHeadset();
        return object;
    }
}
