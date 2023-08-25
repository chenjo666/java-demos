package com.cj.design_pattern.structural_07.adapter.Class.template;

public class Adapter extends SourceClass implements ITarget {
    @Override
    public void doSomething() {
        super.doOtherThing();
    }
}
