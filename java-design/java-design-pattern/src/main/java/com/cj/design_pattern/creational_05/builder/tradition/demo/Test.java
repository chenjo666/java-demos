package com.cj.design_pattern.creational_05.builder.tradition.demo;

public class Test {
    public static void main(String[] args) {
        // 女娲
        God Nuwa = new God(new AsiaHumanBuilder());
        System.out.println(Nuwa.buildHuman());
        // 盖亚
        God Gaiya = new God(new EuropeHumanBuilder());
        System.out.println(Gaiya.buildHuman());
        // 安玛
        God Amma = new God(new AfricaHumanBuilder());
        System.out.println(Amma.buildHuman());
    }
}
//Human{name='张三', gender='男', color='黄'}
//Human{name='Alice', gender='女', color='白'}
//Human{name='巴德', gender='null', color='黑'}