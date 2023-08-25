package com.cj.design_pattern.Singleton.demo;

public class Test {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        if (obj1 == obj2) {
            System.out.println("obj1和obj2是同一个实例！");
        } else {
            System.out.println("obj1和obj2不是同一个实例！");
        }
    }
}
//当前生成一个实例！
//obj1和obj2是同一个实例！