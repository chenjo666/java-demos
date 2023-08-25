package com.cj.design_principle.open_close.forAbstract.demo;

public class Bird extends Animal {

    @Override
    public void eat() {
        System.out.println("鸟正在吃东西");
    }

    @Override
    public void see() {
        System.out.println("鸟正在观察四周");
    }
}
