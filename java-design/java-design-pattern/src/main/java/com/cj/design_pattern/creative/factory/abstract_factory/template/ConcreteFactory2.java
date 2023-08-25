package com.cj.design_pattern.creative.factory.abstract_factory.template;

public class ConcreteFactory2 extends AbstractFactory {
    @Override
    public IProduct1 createProduct1() {
        return new ConcreteProduct1_2();
    }

    @Override
    public IProduct2 createProduct2() {
        return new ConcreteProduct2_2();
    }
}
