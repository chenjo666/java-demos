package com.cj.design_pattern.Singleton.lazy.threadSafe;

public class Singleton1 {
    private static Singleton1 singleton1;
    private Singleton1() {}
    public static synchronized Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
