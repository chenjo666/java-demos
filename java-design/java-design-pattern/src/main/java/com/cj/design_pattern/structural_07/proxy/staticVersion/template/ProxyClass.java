package com.cj.design_pattern.structural_07.proxy.staticVersion.template;

public class ProxyClass implements Interface {
    private TargetClass targetClass;
    public ProxyClass() {
        this.targetClass = new TargetClass();
    }
    public void before() {}
    public void after() {}
    @Override
    public void doSomething() {
       before();
       targetClass.doSomething();
       after();
    }
}
