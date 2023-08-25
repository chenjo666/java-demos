package com.cj.design_pattern.creational_05.abstract_factory.questions.q2;

public class AnimalPainter extends PaintFactory {
    @Override
    public Head paintHead() {
        return new AnimalHead();
    }

    @Override
    public Body paintBody() {
        return new AnimalBody();
    }

    @Override
    public Limb paintLimb() {
        return new AnimalLimb();
    }
}
