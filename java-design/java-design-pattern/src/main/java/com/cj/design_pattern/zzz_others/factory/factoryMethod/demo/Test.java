package com.cj.design_pattern.zzz_others.factory.factoryMethod.demo;


public class Test {
    public static void main(String[] args) {
        AnimalFactory factory = new CatFactory();
        Animal cat = factory.createAnimal();
        cat.shout();

        factory = new DogFactory();
        Animal dog = factory.createAnimal();
        dog.shout();
    }
}
//喵喵...
//汪汪...