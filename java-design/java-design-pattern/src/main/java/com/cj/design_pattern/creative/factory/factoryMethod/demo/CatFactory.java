package com.cj.design_pattern.creative.factory.factoryMethod.demo;

public class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
