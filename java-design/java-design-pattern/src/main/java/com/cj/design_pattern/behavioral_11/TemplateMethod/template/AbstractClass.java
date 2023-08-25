package com.cj.design_pattern.behavioral_11.TemplateMethod.template;

public abstract class AbstractClass {

    public abstract void method1();

    public abstract void method2();

    public abstract void method3();

    public final void templateMethod() {
        method1();
        method2();
        method3();
    }
}
