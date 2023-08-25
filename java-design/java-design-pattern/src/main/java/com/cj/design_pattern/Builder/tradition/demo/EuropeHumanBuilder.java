package com.cj.design_pattern.Builder.tradition.demo;

public class EuropeHumanBuilder implements HumanBuilder {
    private Human human;

    public EuropeHumanBuilder() {
        this.human = new Human();
    }
    @Override
    public void builderName() {
        this.human.setName("Alice");
    }

    @Override
    public void builderGender() {
        this.human.setGender("女");
    }

    @Override
    public void builderColor() {
        this.human.setColor("白");
    }

    @Override
    public Human getHuman() {
        return this.human;
    }
}
