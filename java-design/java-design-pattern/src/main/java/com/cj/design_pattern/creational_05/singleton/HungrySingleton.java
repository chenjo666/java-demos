package com.cj.design_pattern.creational_05.singleton;

public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();
    private HungrySingleton() {}
    public static HungrySingleton getSingleton() {
        return singleton;
    }
}
