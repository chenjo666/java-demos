package com.cj.design_pattern.structural_07.Bridge;

abstract class Abstraction {
    private Implementor implementor;
    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    public Implementor getImplementor() {
        return implementor;
    }
    public abstract void operation();
}
class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }
    @Override
    public void operation() {
        this.getImplementor().operationImpl();
    }
}
interface Implementor {
    void operationImpl();
}
class ConcreteImplementor implements Implementor {
    @Override
    public void operationImpl() {

    }
}
public class BridgeTemplate {
}
