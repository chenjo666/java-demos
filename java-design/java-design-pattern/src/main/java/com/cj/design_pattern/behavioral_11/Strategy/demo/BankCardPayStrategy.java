package com.cj.design_pattern.behavioral_11.Strategy.demo;

public class BankCardPayStrategy implements IPayStrategy {
    @Override
    public void payoff() {
        System.out.println("银行卡支付中...");
    }
}
