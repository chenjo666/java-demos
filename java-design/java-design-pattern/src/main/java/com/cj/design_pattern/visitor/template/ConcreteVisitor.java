package com.cj.design_pattern.visitor.template;

public class ConcreteVisitor implements Visitor {

    @Override
    public void visit(ConcreteElement1 concreteElement1) {
        // 对元素 1 的操作
    }

    @Override
    public void visit(ConcreteElement2 concreteElement2) {
        // 对元素 2 的操作
    }
}
