package com.cj.design_pattern.zzz_others.factory.factoryMethod.template;

public class Item2Factory extends AbstractFactory {
    @Override
    public Product createProduct() {
        return new Item2();
    }
}
