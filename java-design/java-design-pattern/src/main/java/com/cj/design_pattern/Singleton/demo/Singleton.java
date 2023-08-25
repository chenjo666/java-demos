package com.cj.design_pattern.Singleton.demo;

public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){
        System.out.println("当前生成一个实例！");
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
