package com.cj.design_pattern.creative.factory.abstract_factory.demo;

public class SmallCat extends Cat {

    @Override
    public void shout() {
        System.out.println("smallCat is shout");
    }

    @Override
    public void printSize() {
        System.out.println("smallCat is small");
    }
}
