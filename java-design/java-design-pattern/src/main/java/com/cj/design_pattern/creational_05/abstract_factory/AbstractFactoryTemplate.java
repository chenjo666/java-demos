package com.cj.design_pattern.creational_05.abstract_factory;

interface IProduct1 {
}

interface IProduct2 {
}

class ConcreteProduct1_1 implements IProduct1 {
}

class ConcreteProduct1_2 implements IProduct1 {
}

class ConcreteProduct2_1 implements IProduct2 {
}

class ConcreteProduct2_2 implements IProduct2 {
}

abstract class AbstractFactory {
    public abstract IProduct1 createProduct1();

    public abstract IProduct2 createProduct2();
}

class ConcreteFactory1 extends AbstractFactory {

    @Override
    public IProduct1 createProduct1() {
        return new ConcreteProduct1_1();
    }

    @Override
    public IProduct2 createProduct2() {
        return new ConcreteProduct2_1();
    }
}

class ConcreteFactory2 extends AbstractFactory {
    @Override
    public IProduct1 createProduct1() {
        return new ConcreteProduct1_2();
    }

    @Override
    public IProduct2 createProduct2() {
        return new ConcreteProduct2_2();
    }
}

public class AbstractFactoryTemplate {
    public static void main(String[] args) {

    }
}
