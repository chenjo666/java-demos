package com.cj.design_pattern.creational_05.simple_factory;

interface Product {
}
class Item1 implements Product {
}
class Item2 implements Product {
}
class Factory {
    public Product createProduct(Class<?> clazz) {
        if (clazz == Item1.class) {
            return new Item1();
        } else if (clazz == Item2.class) {
            return new Item2();
        }
        return null;
    }
}


public class SimpleFactoryTemplate {
    public static void main(String[] args) {

    }
}
