package com.cj.design_pattern.TemplateMethod.demo;

public abstract class WashingMachine {
    public void open() {
        System.out.println("洗衣机已打开开关！");
    }
    public abstract void setMode();
    public void start() {
        System.out.println("洗衣机运行中！");
    }
    public final void wash() {
        open();
        setMode();
        start();
    }
}
