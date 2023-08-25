package com.cj.design_pattern.Builder.chain.template;

public abstract class AbstractBuilder {
    public abstract AbstractBuilder buildPartA();
    public abstract AbstractBuilder buildPartB();
    public abstract AbstractBuilder buildPartC();
    public abstract Product build();
}
