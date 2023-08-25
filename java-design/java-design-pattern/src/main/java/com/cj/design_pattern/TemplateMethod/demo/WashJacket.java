package com.cj.design_pattern.TemplateMethod.demo;

public class WashJacket extends WashingMachine {
    @Override
    public void setMode() {
        System.out.println("当前模式：52L水，强洗 - 柔洗");
    }
}
