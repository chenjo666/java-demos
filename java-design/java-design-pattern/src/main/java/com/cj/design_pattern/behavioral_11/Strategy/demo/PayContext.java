package com.cj.design_pattern.behavioral_11.Strategy.demo;


public class PayContext {
    public void executePayoff(IPayStrategy strategy) {
        strategy.payoff();
    }
}