package com.cj.design_pattern.creative.factory.abstract_factory.demo;

public class SmallAnimalFactory extends AnimalFactory {
    @Override
    public Cat createCat() {
        return new SmallCat();
    }

    @Override
    public Dog createDog() {
        return new SmallDog();
    }
}
