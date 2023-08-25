package com.cj.design_principle.dependence_inversion.solution;

public class SchoolCardPay implements IPay {
    @Override
    public void payOff() {
        System.out.println("正在使用校园卡进行支付！");
    }
}
