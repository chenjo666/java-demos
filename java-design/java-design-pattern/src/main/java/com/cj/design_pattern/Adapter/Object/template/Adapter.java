package com.cj.design_pattern.Adapter.Object.template;


public class Adapter implements ITarget {
    private SourceClass sourceClass;

    public Adapter() {
        this.sourceClass = new SourceClass();
    }

    @Override
    public void doOtherThing() {
        sourceClass.doBaseThing();
    }
}
