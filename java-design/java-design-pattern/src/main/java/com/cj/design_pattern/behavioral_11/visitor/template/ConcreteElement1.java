package com.cj.design_pattern.behavioral_11.visitor.template;

public class ConcreteElement1 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
