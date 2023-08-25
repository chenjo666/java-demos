package com.cj.design_pattern.creative.factory.factoryMethod.demo;

public class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
