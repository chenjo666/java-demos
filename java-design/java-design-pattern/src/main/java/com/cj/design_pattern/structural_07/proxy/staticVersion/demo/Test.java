package com.cj.design_pattern.structural_07.proxy.staticVersion.demo;

public class Test {
    public static void main(String[] args) {
        Phone phoneSeller = new PhoneSeller();
        phoneSeller.sellPhone();
    }
}
//手机出厂商已卖出手机！
//手机售卖商已赠送耳机！
