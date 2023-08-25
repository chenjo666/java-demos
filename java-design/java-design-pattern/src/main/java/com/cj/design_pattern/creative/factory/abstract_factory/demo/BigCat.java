package com.cj.design_pattern.creative.factory.abstract_factory.demo;

public class BigCat extends Cat {
    @Override
    public void shout() {
        System.out.println("bigCat is shout");
    }

    @Override
    public void printSize() {
        System.out.println("bigCat is big");
    }
}
