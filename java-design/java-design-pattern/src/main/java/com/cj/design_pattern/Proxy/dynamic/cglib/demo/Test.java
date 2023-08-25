package com.cj.design_pattern.Proxy.dynamic.cglib.demo;

public class Test {
    public static void main(String[] args) {
        PhoneProvider phoneSeller = (PhoneProvider) ProxyFactory.getProxy(PhoneProvider.class);
        phoneSeller.sellPhone();
    }
}
//提供咨询服务！
//出售手机！
//赠送蓝牙耳机！
