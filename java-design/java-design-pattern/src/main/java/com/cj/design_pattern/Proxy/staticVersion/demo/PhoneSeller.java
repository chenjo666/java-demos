package com.cj.design_pattern.Proxy.staticVersion.demo;

public class PhoneSeller implements Phone {

    private PhoneProvider phoneProvider;

    public PhoneSeller() {
        this.phoneProvider = new PhoneProvider();
    }

    public void freeHeadset() {
        System.out.println("手机售卖商已赠送耳机！");
    }
    public void askForHelp() {
        System.out.println("手机售卖商已提供咨询！");
    }
    @Override
    public void sellPhone() {
        askForHelp();
        phoneProvider.sellPhone();
        freeHeadset();
    }
}
