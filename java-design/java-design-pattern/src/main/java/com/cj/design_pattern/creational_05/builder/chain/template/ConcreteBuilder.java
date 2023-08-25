package com.cj.design_pattern.creational_05.builder.chain.template;

public class ConcreteBuilder extends AbstractBuilder {
    private Product product;

    public ConcreteBuilder() {
        this.product = new Product();
    }
    @Override
    public ConcreteBuilder buildPartA() {
        return this;
    }

    @Override
    public ConcreteBuilder buildPartB() {
        return this;
    }

    @Override
    public ConcreteBuilder buildPartC() {
        return this;
    }

    @Override
    public Product build() {
        return this.product;
    }
}
