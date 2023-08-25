package com.cj.design_pattern.creative.abstract_factory.questions.q1;

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