package com.cj.jvm.test;


import java.util.Random;
public class Test003 {
    public static void main(String[] args) {
        System.out.println(Parent.a);

    }
}
class Parent {
    static int a = 1;
    static {
        System.out.println("parent's a:" + a);
    }
}
class Sub1 extends Parent {
    static {
        System.out.println("sub1");
    }
}
class Sub2 extends Parent {
    static {
        System.out.println("sub2");
    }
}
