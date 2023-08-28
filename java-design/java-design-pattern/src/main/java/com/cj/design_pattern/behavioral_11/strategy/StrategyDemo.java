package com.cj.design_pattern.behavioral_11.strategy;

import java.util.Random;

// 支付接口
interface IPayStrategy {
    void payoff(double price);
}

// 银行卡支付
class BankCardPayStrategy implements IPayStrategy {
    @Override
    public void payoff(double price) {
        price -= Math.round(new Random().nextDouble() * 100) * 0.01;
        System.out.println("银行卡支付，共支付" + price + "元");
    }
}

// 支付宝支付
class AlipayPayStrategy implements IPayStrategy {
    @Override
    public void payoff(double price) {
        System.out.println("支付宝支付，共支付" + price + "元");
    }
}

// 微信支付
class WechatPayStrategy implements IPayStrategy {
    @Override
    public void payoff(double price) {
        System.out.println("微信支付，共支付" + price + "元");
    }
}

// 支付服务
class PayService {
    public void payoffOrder(double price, IPayStrategy strategy) {
        strategy.payoff(price);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        PayService payService = new PayService();
        payService.payoffOrder(19.90, new BankCardPayStrategy());
        payService.payoffOrder(19.90, new WechatPayStrategy());
        payService.payoffOrder(19.90, new AlipayPayStrategy());
    }
}
//银行卡支付，共支付19.16元
//微信支付，共支付19.9元
//支付宝支付，共支付19.9元