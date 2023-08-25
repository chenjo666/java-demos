package com.cj.design_pattern.creational_05.abstract_factory.questions.q1;

public class ShangHai extends CityFactory {
    @Override
    public ScenicSpot createScenicSpot() {
        return new ShangHaiSpot();
    }

    @Override
    public CelebrityDeed createCelebrityDeed() {
        return new ShangHaiDeed();
    }
}
