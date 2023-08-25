package com.cj.design_pattern.Builder.tradition.template;

public class ConcreteBuilder3 implements IBuilder {
    private Product product;
    public ConcreteBuilder3() {
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
