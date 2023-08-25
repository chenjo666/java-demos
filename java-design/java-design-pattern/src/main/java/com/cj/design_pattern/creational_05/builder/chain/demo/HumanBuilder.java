package com.cj.design_pattern.creational_05.builder.chain.demo;

public class HumanBuilder extends AbstractHumanBuilder {
    private Human human;
    public HumanBuilder() {
        this.human = new Human();
    }
    public HumanBuilder buildName(String name) {
        this.human.setName(name);
        return this;
    }
    public HumanBuilder buildGender(String gender) {
        this.human.setGender(gender);
        return this;
    }
    public HumanBuilder buildColor(String color) {
        this.human.setColor(color);
        return this;
    }
    public Human build() {
        return this.human;
    }
}
