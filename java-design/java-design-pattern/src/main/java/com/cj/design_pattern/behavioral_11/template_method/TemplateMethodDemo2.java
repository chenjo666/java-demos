package com.cj.design_pattern.behavioral_11.template_method;

abstract class WashingMachine {
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

class WashShirt extends WashingMachine {
    @Override
    public void setMode() {
        System.out.println("当前模式：20L水，快洗 - 自清洗");
    }
}

class WashJacket extends WashingMachine {
    @Override
    public void setMode() {
        System.out.println("当前模式：52L水，强洗 - 柔洗");
    }
}

public class TemplateMethodDemo2 {
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
