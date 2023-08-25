package com.cj.design_pattern.creative.simple_factory;

/**
 * 工厂模式（简单工厂模式）的应用
 */

// 动物接口
interface Animal {
    void shout();
}
// 猫
class Cat implements Animal {
    @Override
    public void shout() {
        System.out.println("miao miao...");
    }
}
// 狗
class Dog implements Animal {
    @Override
    public void shout() {
        System.out.println("wang wang...");
    }
}
// 工厂
class AnimalFactory {
    public static Animal createAnimal(Class<?> clazz) {
        if (clazz == Cat.class) {
            return new Cat();
        } else if (clazz == Dog.class) {
            return new Dog();
        }
        return null;
    }
}

public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Animal cat = AnimalFactory.createAnimal(Cat.class);
        cat.shout();
        Animal dog = AnimalFactory.createAnimal(Dog.class);
        dog.shout();
    }
}
//miao miao...
//wang wang...