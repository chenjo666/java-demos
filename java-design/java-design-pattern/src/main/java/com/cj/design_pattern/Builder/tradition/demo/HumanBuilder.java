package com.cj.design_pattern.Builder.tradition.demo;

public interface HumanBuilder {
    void builderName();
    void builderGender();
    void builderColor();

    Human getHuman();
}
