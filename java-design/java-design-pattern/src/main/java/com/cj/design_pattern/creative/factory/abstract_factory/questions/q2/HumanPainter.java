package com.cj.design_pattern.creative.factory.abstract_factory.questions.q2;

public class HumanPainter extends PaintFactory {
    @Override
    public Head paintHead() {
        return new HumanHead();
    }

    @Override
    public Body paintBody() {
        return new HumanBody();
    }

    @Override
    public Limb paintLimb() {
        return new HumanLimb();
    }
}
