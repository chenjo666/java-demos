package com.cj.design_principle.dependence_inversion.solution;

public class ScanCodePay implements IPay {

    @Override
    public void payOff() {
        System.out.println("正在使用扫码进行支付！");
    }
}
