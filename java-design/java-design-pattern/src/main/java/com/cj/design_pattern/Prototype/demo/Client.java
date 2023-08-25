package com.cj.design_pattern.Prototype.demo;

class Phone {
    private String name;

    public Phone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Person implements Cloneable {
    private Phone phone;

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
    public Phone getPhone() {
        return phone;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person person = (Person)super.clone();
        person.setPhone(new Phone(this.phone.getName()));
        return person;
    }

}
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setPhone(new Phone("华为"));
        Person person2 = (Person)person.clone();
        person2.getPhone().setName("苹果");
        System.out.println("实体人的手机名称：" + person.getPhone().getName() + ", 手机地址：" + person.getPhone());
        System.out.println("克隆人的手机名称：" + person2.getPhone().getName() + ", 手机地址：" + person2.getPhone());
    }
}
//实体人的手机名称：华为, 手机地址：designPattern.Prototype.demo.Phone@682a0b20
//克隆人的手机名称：苹果, 手机地址：designPattern.Prototype.demo.Phone@3d075dc0