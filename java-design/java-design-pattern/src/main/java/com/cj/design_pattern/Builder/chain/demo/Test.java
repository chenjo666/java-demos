package com.cj.design_pattern.Builder.chain.demo;

public class Test {
    public static void main(String[] args) {
        AbstractHumanBuilder humanBuilder = new HumanBuilder();
        Human human = humanBuilder.buildName("李四")
                .buildColor("黄")
                .buildGender("男")
                .build();
        System.out.println(human);
    }
}
