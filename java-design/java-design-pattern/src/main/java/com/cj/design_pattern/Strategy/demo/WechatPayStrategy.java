package com.cj.design_pattern.Strategy.demo;

public class WechatPayStrategy implements IPayStrategy {
    @Override
    public void payoff() {
        System.out.println("微信支付中...");
    }
}
