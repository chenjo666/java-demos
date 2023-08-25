package com.cj.design_pattern.structural_07.proxy.dynamic.cglib.template;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyMethodInterceptor implements MethodInterceptor {

    public void before(){}
    public void after(){}
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object object = methodProxy.invokeSuper(o, objects);
        after();
        return object;
    }
}
