package com.cj.design_pattern.creational_05.builder.chain.demo;

public abstract class AbstractHumanBuilder {
    public abstract AbstractHumanBuilder buildName(String name);
    public abstract AbstractHumanBuilder buildGender(String Gender);
    public abstract AbstractHumanBuilder buildColor(String color);

    public abstract Human build();
}
