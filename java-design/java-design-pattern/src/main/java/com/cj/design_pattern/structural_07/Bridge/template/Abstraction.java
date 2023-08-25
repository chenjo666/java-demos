package com.cj.design_pattern.structural_07.Bridge.template;

public abstract class Abstraction {
    private Implementor implementor;
    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    public Implementor getImplementor() {
        return implementor;
    }
    public abstract void operation();
}
