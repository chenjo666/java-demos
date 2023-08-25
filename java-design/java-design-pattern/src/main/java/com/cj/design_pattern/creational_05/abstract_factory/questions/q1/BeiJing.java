package com.cj.design_pattern.creational_05.abstract_factory.questions.q1;

public class BeiJing extends CityFactory {

    @Override
    public ScenicSpot createScenicSpot() {
        return new BeiJingSpot();
    }

    @Override
    public CelebrityDeed createCelebrityDeed() {
        return new BeiJingDeed();
    }
}
