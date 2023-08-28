package com.cj.design_pattern.behavioral_11.template_method;

abstract class AbstractTemplateMethod {

    public abstract void method1();

    public abstract void method2();

    public abstract void method3();

    public final void templateMethod() {
        method1();
        method2();
        method3();
    }
}
class ConcreteMethod1 extends AbstractTemplateMethod {

    @Override
    public void method1() {}

    @Override
    public void method2() {}

    @Override
    public void method3() {}
}
class ConcreteMethod2 extends AbstractTemplateMethod {

    @Override
    public void method1() {}

    @Override
    public void method2() {}

    @Override
    public void method3() {}
}

public class TemplateMethodTemplate {
    public static void main(String[] args) {

    }
}
