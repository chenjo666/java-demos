package com.cj.design_pattern.creative.factory.abstract_factory.demo;

public class BigAnimalFactory extends AnimalFactory {
    @Override
    public Cat createCat() {
        return new BigCat();
    }

    @Override
    public Dog createDog() {
        return new BigDog();
    }
}
