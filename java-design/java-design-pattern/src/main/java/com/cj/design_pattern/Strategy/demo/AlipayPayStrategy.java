package com.cj.design_pattern.Strategy.demo;

public class AlipayPayStrategy implements IPayStrategy {
    @Override
    public void payoff() {
        System.out.println("支付宝支付中...");
    }
}
