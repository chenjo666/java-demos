package com.cj.design_pattern.creational_05.singleton;

public class LockSingleton {
    private static LockSingleton singleton;
    private LockSingleton() {}
    public static synchronized LockSingleton getInstance() {
        if (singleton == null) {
            singleton = new LockSingleton();
        }
        return singleton;
    }
//    public static LockSingleton getInstance() {
//        synchronized (LockSingleton.class) {
//            if (singleton == null) {
//                singleton = new LockSingleton();
//            }
//        }
//        return singleton;
//    }
}
