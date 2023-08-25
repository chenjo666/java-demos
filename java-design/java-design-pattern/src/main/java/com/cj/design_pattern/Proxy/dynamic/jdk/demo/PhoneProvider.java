package com.cj.design_pattern.Proxy.dynamic.jdk.demo;

public class PhoneProvider implements Phone {

    @Override
    public void sellPhone() {
        System.out.println("出售手机！");
    }
}
