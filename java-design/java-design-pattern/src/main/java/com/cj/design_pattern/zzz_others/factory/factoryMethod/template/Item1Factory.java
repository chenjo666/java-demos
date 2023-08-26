package com.cj.design_pattern.zzz_others.factory.factoryMethod.template;

public class Item1Factory extends AbstractFactory {

    @Override
    public Product createProduct() {
        return new Item1();
    }
}
