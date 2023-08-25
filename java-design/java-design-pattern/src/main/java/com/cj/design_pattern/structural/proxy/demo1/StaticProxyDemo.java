package com.cj.design_pattern.structural.proxy.demo1;

// 手机出售商
interface PhoneSeller {
    double sellerPhone(String phone, double price);
}

// OPPO 手机出售商
class OPPOPhoneSeller implements PhoneSeller {
    private static final String RENO9_NAME = "Reno9";
    private static final double RENO9_PRICE = 2399;
    @Override
    public double sellerPhone(String phone, double price) {
        if (!phone.equals(RENO9_NAME)) {
            return -1;
        }
        if (price < RENO9_PRICE) {
            return -1;
        }
        return price - RENO9_PRICE;
    }
}

// OPPO 手机出售商代理商，比如售卖点，此时会贵一点出售
class OPPOPhoneSellerProxy implements PhoneSeller {
    private OPPOPhoneSeller oppoPhoneSeller;
    private static final double EXPENSIVE_PRICE = 300;

    public OPPOPhoneSellerProxy(OPPOPhoneSeller oppoPhoneSeller) {
        this.oppoPhoneSeller = oppoPhoneSeller;
    }

    @Override
    public double sellerPhone(String phone, double price) {
        return oppoPhoneSeller.sellerPhone(phone, price - EXPENSIVE_PRICE);
    }
}

public class StaticProxyDemo {
    public static void main(String[] args) {
        OPPOPhoneSeller oppoPhoneSeller = new OPPOPhoneSeller();
        // 直接找手机出售商购买
        double res = oppoPhoneSeller.sellerPhone("Reno9", 2500);
        System.out.println("结果: " + res);
        // 找手机代理商购买
        OPPOPhoneSellerProxy oppoPhoneSellerProxy = new OPPOPhoneSellerProxy(oppoPhoneSeller);
        double res2 = oppoPhoneSellerProxy.sellerPhone("Reno9", 2500);
        System.out.println("结果: " + res2);
    }
}
//结果: 101.0
//结果: -1.0