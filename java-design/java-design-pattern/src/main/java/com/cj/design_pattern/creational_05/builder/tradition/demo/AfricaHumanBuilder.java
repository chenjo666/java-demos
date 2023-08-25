package com.cj.design_pattern.creational_05.builder.tradition.demo;

public class AfricaHumanBuilder implements HumanBuilder {
    private Human human;

    public AfricaHumanBuilder() {
        this.human = new Human();
    }
    @Override
    public void builderName() {
        this.human.setName("巴德");
    }

    @Override
    public void builderGender() {

    }

    @Override
    public void builderColor() {
        this.human.setColor("黑");
    }

    @Override
    public Human getHuman() {
        return this.human;
    }
}
