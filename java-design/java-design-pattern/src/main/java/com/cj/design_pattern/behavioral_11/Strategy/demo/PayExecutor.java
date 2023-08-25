package com.cj.design_pattern.behavioral_11.Strategy.demo;


public class PayExecutor {
    public void executePayoff(IPayStrategy strategy) {
        strategy.payoff();
    }
}
