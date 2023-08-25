package com.cj.design_pattern.Builder.tradition.demo;


public class God {
    private HumanBuilder builder;
    public God(HumanBuilder builder) {
        this.builder = builder;
    }
    public Human buildHuman() {
        this.builder.builderName();
        this.builder.builderGender();
        this.builder.builderColor();
        return builder.getHuman();
    }
}
