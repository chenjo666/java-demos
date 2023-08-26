package com.cj.design_pattern.creational_05.builder;

 class Product {
    private Object partA;
    private Object partB;
    private Object partC;
}
 abstract class AbstractBuilder {
    public abstract AbstractBuilder buildPartA();
    public abstract AbstractBuilder buildPartB();
    public abstract AbstractBuilder buildPartC();
    public abstract Product build();
}
class ConcreteBuilder extends AbstractBuilder {
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
public class ChainBuilderTemplate {
}
