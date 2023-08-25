package com.cj.design_pattern.creational_05.builder.tradition.template;

public class Director {
    private IBuilder builder;

    public Director(IBuilder builder) {
        this.builder = builder;
    }
    public Product build() {
        builder.buildA();
        builder.buildB();
        builder.buildC();
        return builder.getProduct();
    }
}
