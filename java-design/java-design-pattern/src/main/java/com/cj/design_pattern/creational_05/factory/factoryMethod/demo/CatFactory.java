package com.cj.design_pattern.creational_05.factory.factoryMethod.demo;

public class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
