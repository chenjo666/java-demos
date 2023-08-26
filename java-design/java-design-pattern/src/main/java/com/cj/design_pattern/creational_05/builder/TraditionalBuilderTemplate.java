package com.cj.design_pattern.creational_05.builder;

class BuildObject {
    private Object partA;
    private Object partB;
    private Object partC;
}
 interface IBuilder {
    void buildA();
    void buildB();
    void buildC();
    BuildObject getBuilderObject();
}
 class Director {
    private IBuilder builder;
    public Director(IBuilder builder) {
        this.builder = builder;
    }
    public BuildObject build() {
        builder.buildA();
        builder.buildB();
        builder.buildC();
        return builder.getBuilderObject();
    }
}
class ConcreteBuilder1 implements IBuilder {
    private BuildObject buildObject;
    public ConcreteBuilder1() {
        this.buildObject = new BuildObject();
    }
    @Override
    public void buildA() {}
    @Override
    public void buildB() {}
    @Override
    public void buildC() {}
    @Override
    public BuildObject getBuilderObject() {
        return this.buildObject;
    }
}
class ConcreteBuilder2 implements IBuilder {
    private BuildObject buildObject;
    public ConcreteBuilder2() {
        this.buildObject = new BuildObject();
    }
    @Override
    public void buildA() {}
    @Override
    public void buildB() {}
    @Override
    public void buildC() {}
    @Override
    public BuildObject getBuilderObject() {
        return this.buildObject;
    }
}
class ConcreteBuilder3 implements IBuilder {
    private BuildObject buildObject;
    public ConcreteBuilder3() {
        this.buildObject = new BuildObject();
    }
    @Override
    public void buildA() {}
    @Override
    public void buildB() {}
    @Override
    public void buildC() {}
    @Override
    public BuildObject getBuilderObject() {
        return this.buildObject;
    }
}

public class TraditionalBuilderTemplate {
}
