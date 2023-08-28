package com.cj.design_pattern.behavioral_11.strategy;

interface IStrategy {
    void strategyMethod();
}

class ConcreteStrategy1 implements IStrategy {
    @Override
    public void strategyMethod() {

    }
}

class ConcreteStrategy2 implements IStrategy {
    @Override
    public void strategyMethod() {

    }
}

class ConcreteStrategy3 implements IStrategy {
    @Override
    public void strategyMethod() {

    }
}

class StrategyExecutor {
    public void executeStrategy(IStrategy strategy) {

    }
}

public class StrategyTemplate {
}
