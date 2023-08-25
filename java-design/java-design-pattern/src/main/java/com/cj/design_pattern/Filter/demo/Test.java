package com.cj.design_pattern.Filter.demo;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Human> humans = new LinkedList<>();
        humans.add(new Human("张飞", "男", "黄"));
        humans.add(new Human("莉莉", "女", "黄"));
        humans.add(new Human("艾伦", "男", "白"));
        humans.add(new Human("爱丽丝", "女", "白"));

        IHumanFilter manFilter = new ManFilter();
        System.out.println("男人：");
        printList(manFilter.humanFilter(humans));

        IHumanFilter woManFilter = new WoManFilter();
        System.out.println("女人：");
        printList(woManFilter.humanFilter(humans));

        IHumanFilter yellowHumanFilter = new YellowHumanFilter();
        System.out.println("黄种人：");
        printList(yellowHumanFilter.humanFilter(humans));

        IHumanFilter whiteHumanFilter = new WhiteHumanFilter();
        System.out.println("白种人：");
        printList(whiteHumanFilter.humanFilter(humans));
    }
    private static void printList(List<Human> humans) {
        for (Human human : humans) {
            System.out.println(human);
        }
    }
}
//男人：
//Human{name='张飞', gender='男', color='黄'}
//Human{name='艾伦', gender='男', color='白'}
//女人：
//Human{name='莉莉', gender='女', color='黄'}
//Human{name='爱丽丝', gender='女', color='白'}
//黄种人：
//Human{name='张飞', gender='男', color='黄'}
//Human{name='莉莉', gender='女', color='黄'}
//白种人：
//Human{name='艾伦', gender='男', color='白'}
//Human{name='爱丽丝', gender='女', color='白'}