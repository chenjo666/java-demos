package com.cj.design_pattern.Filter.demo;

public class Human {
    private String name;
    private String gender;
    private String color;

    public Human(String name, String gender, String color) {
        this.name = name;
        this.gender = gender;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getColor() {
        return color;
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
