package com.cj.design_pattern.creational_05.singleton;

// 静态内部类
public class StaticInnerSingleton {
    private StaticInnerSingleton() {}
    private static class SingletonHolder {
        private static final StaticInnerSingleton singleton = new StaticInnerSingleton();
    }
    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.singleton;
    }
}
