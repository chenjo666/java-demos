package com.cj.design_pattern.creational_05.builder;


class Human {
    private String name;
    private String gender;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

interface HumanBuilder {
    void builderName();

    void builderGender();

    void builderColor();

    Human getHuman();
}

class EuropeHumanBuilder implements HumanBuilder {
    private Human human;

    public EuropeHumanBuilder() {
        this.human = new Human();
    }

    @Override
    public void builderName() {
        this.human.setName("Alice");
    }

    @Override
    public void builderGender() {
        this.human.setGender("女");
    }

    @Override
    public void builderColor() {
        this.human.setColor("白");
    }

    @Override
    public Human getHuman() {
        return this.human;
    }
}

class AsiaHumanBuilder implements HumanBuilder {
    private Human human;

    public AsiaHumanBuilder() {
        this.human = new Human();
    }

    @Override
    public void builderName() {
        this.human.setName("张三");
    }

    @Override
    public void builderGender() {
        this.human.setGender("男");
    }

    @Override
    public void builderColor() {
        this.human.setColor("黄");
    }

    @Override
    public Human getHuman() {
        return this.human;
    }
}

 class AfricaHumanBuilder implements HumanBuilder {
    private Human human;

    public AfricaHumanBuilder() {
        this.human = new Human();
    }

    @Override
    public void builderName() {
        this.human.setName("巴德");
    }

    @Override
    public void builderGender() {

    }

    @Override
    public void builderColor() {
        this.human.setColor("黑");
    }

    @Override
    public Human getHuman() {
        return this.human;
    }
}

class God {
    private HumanBuilder builder;

    public God(HumanBuilder builder) {
        this.builder = builder;
    }

    public Human buildHuman() {
        this.builder.builderName();
        this.builder.builderGender();
        this.builder.builderColor();
        return builder.getHuman();
    }
}

public class TraditionalBuilderDemo {
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