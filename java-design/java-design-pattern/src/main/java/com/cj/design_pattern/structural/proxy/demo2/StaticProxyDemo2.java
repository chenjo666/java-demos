package com.cj.design_pattern.structural.proxy.demo2;

// 手机出售商
interface PhoneSeller {
    double sellerPhone(String phone, double price);
}

// oppo 手机出售商
class OppoPhoneSeller implements PhoneSeller {
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
// vivo 手机出售商
class VivoPhoneSeller implements PhoneSeller {
    private static final String VIVO_NAME = "Vivo9";
    private static final double VIVO_PRICE = 2599;
    @Override
    public double sellerPhone(String phone, double price) {
        if (!phone.equals(VIVO_NAME)) {
            return -1;
        }
        if (price < VIVO_PRICE) {
            return -1;
        }
        return price - VIVO_PRICE;
    }
}


// 手机出售代理商
class PhoneSellerProxy implements PhoneSeller {
    private PhoneSeller phoneSeller;
    private static final double EXPENSIVE_PRICE = 300;

    public void setPhoneSeller(PhoneSeller phoneSeller) {
        this.phoneSeller = phoneSeller;
    }

    @Override
    public double sellerPhone(String phone, double price) {
        return phoneSeller.sellerPhone(phone, price - EXPENSIVE_PRICE);
    }
}

public class StaticProxyDemo2 {
    public static void main(String[] args) {
        OppoPhoneSeller oppoPhoneSeller = new OppoPhoneSeller();
        VivoPhoneSeller vivoPhoneSeller = new VivoPhoneSeller();
        PhoneSellerProxy oppoPhoneSellerProxy = new PhoneSellerProxy();
        // 代理 oppo
        oppoPhoneSellerProxy.setPhoneSeller(oppoPhoneSeller);
        double res1 = oppoPhoneSellerProxy.sellerPhone("Reno9", 3000);
        System.out.println("oppo: " + res1);
        // 代理 vivo
        oppoPhoneSellerProxy.setPhoneSeller(vivoPhoneSeller);
        double res2 = oppoPhoneSellerProxy.sellerPhone("Vivo9", 3000);
        System.out.println("vivo: " + res2);
    }
}
//oppo: 301.0
//vivo: 101.0