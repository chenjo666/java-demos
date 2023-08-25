package com.cj.design_pattern.behavioral_11.TemplateMethod.demo;

public class Test {
    public static void main(String[] args) {
        // 洗衬衫
        WashingMachine washShirt = new WashShirt();
        washShirt.wash();
        // 洗棉袄
        WashingMachine washJacket = new WashJacket();
        washJacket.wash();
    }
}
//洗衣机已打开开关！
//当前模式：20L水，快洗 - 自清洗
//洗衣机运行中！
//洗衣机已打开开关！
//当前模式：52L水，强洗 - 柔洗
//洗衣机运行中！
