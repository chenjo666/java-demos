package com.cj.design_principle.interface_segregation.question;

public class Bird implements AnimalBehaviour {
    @Override
    public void fly() {
        System.out.println("我会飞！");
    }

    @Override
    public void run() {

    }


    @Override
    public void swim() {

    }
}
