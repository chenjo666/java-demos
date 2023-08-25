package com.cj.design_principle.open_close.forInterface.demo;

public class Bird extends Animal implements IFly {

    @Override
    public void eat() {
        System.out.println("鸟正在吃东西");
    }

    @Override
    public void see() {
        System.out.println("鸟正在观察四周");
    }

    @Override
    public void fly() {
        System.out.println("鸟正在飞");
    }
}
