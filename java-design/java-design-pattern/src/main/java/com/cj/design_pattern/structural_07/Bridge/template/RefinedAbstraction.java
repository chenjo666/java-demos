package com.cj.design_pattern.structural_07.Bridge.template;

public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }
    @Override
    public void operation() {
        // 具体业务...
        this.getImplementor().operationImpl();
    }
}
