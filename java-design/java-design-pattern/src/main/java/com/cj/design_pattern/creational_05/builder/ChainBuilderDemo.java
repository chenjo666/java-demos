package com.cj.design_pattern.creational_05.builder;

class Person {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

abstract class AbstractPersonBuilder {
    public abstract AbstractPersonBuilder buildName(String name);

    public abstract AbstractPersonBuilder buildGender(String Gender);

    public abstract AbstractPersonBuilder buildColor(String color);

    public abstract Person build();
}

class PersonBuilder extends AbstractPersonBuilder {
    private Person human;

    public PersonBuilder() {
        this.human = new Person();
    }

    public PersonBuilder buildName(String name) {
        this.human.setName(name);
        return this;
    }

    public PersonBuilder buildGender(String gender) {
        this.human.setGender(gender);
        return this;
    }

    public PersonBuilder buildColor(String color) {
        this.human.setColor(color);
        return this;
    }

    public Person build() {
        return this.human;
    }
}

public class ChainBuilderDemo {
    public static void main(String[] args) {
        AbstractPersonBuilder humanBuilder = new PersonBuilder();
        Person human = humanBuilder.buildName("李四")
                .buildColor("黄")
                .buildGender("男")
                .build();
        System.out.println(human);
    }
}
//Person{name='李四', gender='男', color='黄'}