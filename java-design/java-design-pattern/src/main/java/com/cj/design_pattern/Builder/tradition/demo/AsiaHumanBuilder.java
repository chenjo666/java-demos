package com.cj.design_pattern.Builder.tradition.demo;

public class AsiaHumanBuilder implements HumanBuilder {
    private Human human;
    public AsiaHumanBuilder() {
        this.human = new Human();
    }
    @Override
    public void builderName() {
        this.human.setName("张三");
    }

    @Override
    public void builderGender() {
        this.human.setGender("男");
    }

    @Override
    public void builderColor() {
        this.human.setColor("黄");
    }

    @Override
    public Human getHuman() {
        return this.human;
    }
}
