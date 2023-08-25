package com.cj.design_pattern.creative.factory.abstract_factory.demo;

public class Test {
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