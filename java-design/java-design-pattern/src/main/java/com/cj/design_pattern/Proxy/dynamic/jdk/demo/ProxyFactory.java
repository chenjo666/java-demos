package com.cj.design_pattern.Proxy.dynamic.jdk.demo;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static Object getProxy(Object object) {
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new ProxyInvocationHandler(object)
        );
    }
}
