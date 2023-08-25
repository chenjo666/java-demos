package com.cj.design_pattern.Strategy.demo;


public class PayContext {
    public void executePayoff(IPayStrategy strategy) {
        strategy.payoff();
    }
}