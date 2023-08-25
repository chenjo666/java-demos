package com.cj.design_pattern.behavioral_11.Strategy.demo;

public class Test {
    public static void main(String[] args) {
        PayContext payContext = new PayContext();
        payContext.executePayoff(new WechatPayStrategy());
        payContext.executePayoff(new AlipayPayStrategy());
        payContext.executePayoff(new BankCardPayStrategy());
    }
}
//