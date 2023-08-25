package com.cj.design_pattern.creational_05.builder.tradition.template;

public interface IBuilder {
    void buildA();
    void buildB();
    void buildC();
    Product getProduct();
}
