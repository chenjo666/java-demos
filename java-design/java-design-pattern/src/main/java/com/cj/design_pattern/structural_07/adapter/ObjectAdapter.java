package com.cj.design_pattern.structural_07.adapter;

interface ITarget {
    void doOtherThing();
}

class SourceClass {
    public void doBaseThing() {

    }
}

public class ObjectAdapter implements ITarget {
    private SourceClass sourceClass;

    public ObjectAdapter() {
        this.sourceClass = new SourceClass();
    }

    @Override
    public void doOtherThing() {
        sourceClass.doBaseThing();
    }
}
