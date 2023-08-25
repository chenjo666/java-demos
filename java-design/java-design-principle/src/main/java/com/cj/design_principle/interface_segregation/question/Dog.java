package com.cj.design_principle.interface_segregation.question;

public class Dog implements AnimalBehaviour {
    @Override
    public void fly() {

    }

    @Override
    public void run() {
        System.out.println("我会奔跑！");
    }

    @Override
    public void swim() {
        System.out.println("我会游泳！");
    }
}
