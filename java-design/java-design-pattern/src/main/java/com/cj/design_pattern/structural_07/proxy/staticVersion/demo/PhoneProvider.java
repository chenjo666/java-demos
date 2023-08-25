package com.cj.design_pattern.structural_07.proxy.staticVersion.demo;

public class PhoneProvider implements Phone {

    @Override
    public void sellPhone() {
        System.out.println("手机出厂商已卖出手机！");
    }
}
