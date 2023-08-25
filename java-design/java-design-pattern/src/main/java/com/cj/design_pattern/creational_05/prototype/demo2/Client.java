package com.cj.design_pattern.creational_05.prototype.demo2;


class A implements Cloneable {
    private B b;
    public A(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public Object clone() {
        try {
            A a = (A)super.clone();
            a.setB((B)a.getB().clone());
            return a;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
class B implements Cloneable {
    private C c;
    public B(C c) {
        this.c = c;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
class C {

}
public class Client {
    public static void main(String[] args) {
        A a = new A(new B(new C()));
        A a2 = (A)a.clone();
        System.out.println(a.getB() + " " + a2.getB());
        System.out.println(a.getB().getC() + " " + a2.getB().getC());
    }
}
