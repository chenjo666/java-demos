package com.cj.design_pattern.Adapter.Class.template;

public class Adapter extends SourceClass implements ITarget {
    @Override
    public void doSomething() {
        super.doOtherThing();
    }
}
