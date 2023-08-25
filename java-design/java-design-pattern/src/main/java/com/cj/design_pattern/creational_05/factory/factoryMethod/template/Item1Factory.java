package com.cj.design_pattern.creational_05.factory.factoryMethod.template;

public class Item1Factory extends AbstractFactory {

    @Override
    public Product createProduct() {
        return new Item1();
    }
}
