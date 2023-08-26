package com.cj.design_pattern.zzz_others.factory.factoryMethod.demo;

public class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
