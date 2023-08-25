package com.cj.design_pattern.Proxy.dynamic.jdk.demo;

public class Test {
    public static void main(String[] args) {
        Phone phoneSeller = (Phone)ProxyFactory.getProxy(new PhoneProvider());
        phoneSeller.sellPhone();
    }
}
//提供咨询服务！
//出售手机！
//提供蓝牙耳机！
