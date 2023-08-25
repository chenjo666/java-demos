package com.cj.design_pattern.creational_05.factory.factoryMethod.demo;

public class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
