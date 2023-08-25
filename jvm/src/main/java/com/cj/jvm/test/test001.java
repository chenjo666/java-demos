package com.cj.jvm.test;

public class test001 {
    static int a = 1;
    static {
        a = -1;                      // 赋值可以，访问不可以
        System.out.println(a);
//        System.out.println(b);      // 非法前向引用
    }
    static int b;

    public static void main(String[] args) {
        System.out.println(b);
    }
}
