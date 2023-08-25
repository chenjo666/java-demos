package com.cj.design_pattern.creative.factory.abstract_factory.demo;

public class SmallDog extends Dog {
    @Override
    public void shout() {
        System.out.println("smallDog is shout");
    }

    @Override
    public void printSize() {
        System.out.println("smallDog is small");
    }
}
