package com.cj.design_pattern.creational_05.builder.tradition.template;

public class ConcreteBuilder2 implements IBuilder {
    private Product product;

    public ConcreteBuilder2() {
        this.product = new Product();
    }
    @Override
    public void buildA() {

    }

    @Override
    public void buildB() {

    }

    @Override
    public void buildC() {

    }

    @Override
    public Product getProduct() {
        return this.product;
    }
}
