package com.cj.design_principle.liskov_substitution.question;

public class Test {
    public static void main(String[] args) {
        // 使用父类长方形
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(10);
        rectangle.setWidth(20);

        // 使用子类正方形
        Rectangle square = new Square();
        square.setWidth(10);
        square.setHeight(20);

        // 比较长方形和正方形的面积
        System.out.println((rectangle.getArea() == square.getArea()));
        System.out.println("长方形的面积：" + rectangle.getArea());
        System.out.println("正方形的面积：" + square.getArea());
    }
}
