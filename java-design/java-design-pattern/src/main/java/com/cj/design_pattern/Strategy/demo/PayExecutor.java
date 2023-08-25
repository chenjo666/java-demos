package com.cj.design_pattern.Strategy.demo;


public class PayExecutor {
    public void executePayoff(IPayStrategy strategy) {
        strategy.payoff();
    }
}
