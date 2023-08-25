package com.cj.design_pattern.visitor.template;

public class ConcreteElement2 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
