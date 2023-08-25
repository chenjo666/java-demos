package com.cj.design_pattern.structural_07.proxy.dynamic.cglib.template;

import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        // 1.创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 2.设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new ProxyMethodInterceptor());
        // 3.创建代理类
        Object object = enhancer.create();
        return object;
    }
}
