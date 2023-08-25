package com.cj.design_pattern.creative.abstract_factory;

interface Animal {
    void shout();
}
abstract class Cat implements Animal {
    public abstract void printSize();
}
abstract class Dog implements Animal {
    public abstract void printSize();
}
abstract class AnimalFactory {
    public abstract Cat createCat();
    public abstract Dog createDog();
}
class BigCat extends Cat {
    @Override
    public void shout() {
        System.out.println("bigCat is shout");
    }
    @Override
    public void printSize() {
        System.out.println("bigCat is big");
    }
}
class BigDog extends Dog {
    @Override
    public void shout() {
        System.out.println("bigDog is shout");
    }
    @Override
    public void printSize() {
        System.out.println("bigDog is big");
    }
}
class SmallCat extends Cat {
    @Override
    public void shout() {
        System.out.println("smallCat is shout");
    }
    @Override
    public void printSize() {
        System.out.println("smallCat is small");
    }
}
class SmallDog extends Dog {
    @Override
    public void shout() {
        System.out.println("smallDog is shout");
    }
    @Override
    public void printSize() {
        System.out.println("smallDog is small");
    }
}
class BigAnimalFactory extends AnimalFactory {
    @Override
    public Cat createCat() {
        return new BigCat();
    }

    @Override
    public Dog createDog() {
        return new BigDog();
    }
}


class SmallAnimalFactory extends AnimalFactory {
    @Override
    public Cat createCat() {
        return new SmallCat();
    }

    @Override
    public Dog createDog() {
        return new SmallDog();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        BigAnimalFactory bigAnimalFactory = new BigAnimalFactory();
        Cat bigCat = bigAnimalFactory.createCat();
        bigCat.shout();
        bigCat.printSize();
        Dog bigDog = bigAnimalFactory.createDog();
        bigDog.shout();
        bigDog.printSize();

        SmallAnimalFactory smallAnimalFactory = new SmallAnimalFactory();
        Cat smallCat = smallAnimalFactory.createCat();
        smallCat.shout();
        smallCat.printSize();
        Dog smallDog = smallAnimalFactory.createDog();
        smallDog.shout();
        smallDog.printSize();
    }
}
//bigCat is shout
//bigCat is big
//bigDog is shout
//bigDog is big
//smallCat is shout
//smallCat is small
//smallDog is shout
//smallDog is small