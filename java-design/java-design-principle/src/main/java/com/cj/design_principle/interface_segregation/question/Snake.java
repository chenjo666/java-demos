package com.cj.design_principle.interface_segregation.question;

public class Snake implements AnimalBehaviour {
    @Override
    public void fly() {

    }

    @Override
    public void run() {

    }

    @Override
    public void swim() {
        System.out.println("我会游泳！");
    }
}
