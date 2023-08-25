package com.cj.design_pattern.structural_07.proxy.dynamic.jdk.demo;

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
