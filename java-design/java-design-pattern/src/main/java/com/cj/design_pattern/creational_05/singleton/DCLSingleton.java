package com.cj.design_pattern.creational_05.singleton;

// 双重锁定检查（Double-Check-Lock，DCL）
public class DCLSingleton {
    private static volatile DCLSingleton singleton;
    private DCLSingleton() {}
    public static DCLSingleton getInstance() {
        if (singleton == null) {
            synchronized (DCLSingleton.class) {
                if (singleton == null) {
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }
}
