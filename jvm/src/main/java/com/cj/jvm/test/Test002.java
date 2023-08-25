package com.cj.jvm.test;

public class Test002 {
    public static void main(String[] args) throws ClassNotFoundException {
//        new C();
        System.out.println(P.a);

//        System.out.println(C.b);
//        Class<?> pclass = Class.forName(P.class.getName());
//        ThreadLocal
    }

}

class P {
    static int a = 1;
    static {
        System.out.println("p'a: " + a);
    }
}
interface A {
    int b = 1;
    int c = 2;
}
interface B extends A {
    int c = 1;
}
class C extends P implements A{
    static int c = 2;
    static  {
        c = a;
        System.out.println("C'c: "+ c);
    }
}