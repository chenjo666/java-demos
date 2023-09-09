package com.cj.lang;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsHashCodeDemo {
    public static void main(String[] args) {
        // 没有重写 hashCode
        System.out.println("------------------- 仅重写 equals -------------------");
        User user1 = new User("小明", 18);
        User user2 = new User("小明", 18);
        Set<User> set = new HashSet<>();
        set.add(user1);
        set.add(user2);
        set.forEach(user -> {
            System.out.println(user + ":" + user.hashCode());
        });

        // 重写 hashCode
        System.out.println("-------------------- 重写 equals 和 hashCode --------------------");
        Person person1 = new Person("小明", 18);
        Person person2 = new Person("小明", 18);
        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2);
        personSet.forEach(person -> {
            System.out.println(person + ":" + person.hashCode());
        });

    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        // 地址比较相同，则相同对象
        if (this == obj)
            return true;
        // 对象为空或者对象类型不匹配则一定不同
        if (obj == null || getClass() != obj.getClass())
            return false;
        // 比较内容是否相等，内容指属性，int 用 ==，String 用 equals() 比较内容
        User u = (User) obj;
        return age == u.age && name.equals(u.name);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        // 地址比较相同，则相同对象
        if (this == obj)
            return true;
        // 对象为空或者对象类型不匹配则一定不同
        if (obj == null || getClass() != obj.getClass())
            return false;
        // 比较内容是否相等，内容指属性，int 用 ==，String 用 equals() 比较内容
        Person p = (Person) obj;
        return age == p.age && name.equals(p.name);
    }
    @Override
    public int hashCode() {
        // 一个工具方法，把 name 和 age 组合散列成一个 hash 值
        // 具有相同 name 和 age 的对象那么这个 hashCode 一定相同
        return Objects.hash(name, age);
    }
}
