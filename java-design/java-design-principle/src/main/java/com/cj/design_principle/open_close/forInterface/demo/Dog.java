package com.cj.design_principle.open_close.forInterface.demo;

public class Dog extends Animal implements IRun {
    @Override
    public void eat() {
        System.out.println("狗正在吃东西");
    }

    @Override
    public void see() {
        System.out.println("狗正在观察四周");
    }

    @Override
    public void run() {
        System.out.println("狗正在跑");
    }
}
