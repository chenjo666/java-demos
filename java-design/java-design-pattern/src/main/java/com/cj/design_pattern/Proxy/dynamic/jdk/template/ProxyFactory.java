package com.cj.design_pattern.Proxy.dynamic.jdk.template;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static Object getProxy(Object object) {
        // 生成代理对象
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new MyInvocationHandler(object)
        );
    }
}
