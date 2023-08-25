package com.cj.design_pattern.creational_05.builder.tradition.demo;

public interface HumanBuilder {
    void builderName();
    void builderGender();
    void builderColor();

    Human getHuman();
}
