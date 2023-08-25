package com.cj.design_pattern.behavioral_11.TemplateMethod.demo;

public class WashShirt extends WashingMachine {
    @Override
    public void setMode() {
        System.out.println("当前模式：20L水，快洗 - 自清洗");
    }
}
