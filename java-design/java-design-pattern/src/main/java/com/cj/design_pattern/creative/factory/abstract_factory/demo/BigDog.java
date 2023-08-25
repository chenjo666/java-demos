package com.cj.design_pattern.creative.factory.abstract_factory.demo;

public class BigDog extends Dog {
    @Override
    public void shout() {
        System.out.println("bigDog is shout");
    }

    @Override
    public void printSize() {
        System.out.println("bigDog is big");
    }
}
