package com.cj.design_pattern.Singleton.lazy.threadSafe;

public class Singleton2 {
    private static Singleton2 singleton2;
    private Singleton2() {}
    public static synchronized Singleton2 getInstance() {
        synchronized (Singleton2.class) {
            if (singleton2 == null) {
                singleton2 = new Singleton2();
            }
        }
        return singleton2;
    }
}
