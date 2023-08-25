package com.cj.design_pattern.Builder.tradition.template;

public class ConcreteBuilder1 implements IBuilder {
    private Product product;

    public ConcreteBuilder1() {
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
