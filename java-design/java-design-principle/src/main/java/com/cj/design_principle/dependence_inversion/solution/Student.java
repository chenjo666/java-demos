package com.cj.design_principle.dependence_inversion.solution;

public class Student {
    public void pay(IPay pay) {
        pay.payOff();
    }
}