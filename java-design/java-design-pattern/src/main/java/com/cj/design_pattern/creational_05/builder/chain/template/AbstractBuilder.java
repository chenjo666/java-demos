package com.cj.design_pattern.creational_05.builder.chain.template;

public abstract class AbstractBuilder {
    public abstract AbstractBuilder buildPartA();
    public abstract AbstractBuilder buildPartB();
    public abstract AbstractBuilder buildPartC();
    public abstract Product build();
}
