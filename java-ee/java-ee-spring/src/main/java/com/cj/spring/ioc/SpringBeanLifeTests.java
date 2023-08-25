package com.cj.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
class NormalBeanLife {
    public NormalBeanLife() {
        System.out.println("Bean 的构造方法");
    }

    public void setMsg(String msg) {
        System.out.println("Bean 的set方法");
    }

    public void initBean() {
        System.out.println("Bean 的初始化方法");
    }
    public void destroyBean() {
        System.out.println("Bean 的销毁方法");
    }
}
public class SpringBeanLifeTests {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        NormalBeanLife bean = context.getBean("normalBeanLife", NormalBeanLife.class);
        System.out.println("Bean 的正常使用");
        context.close();
    }
}
//Bean 的构造方法
//Bean 的set方法
//Bean 的初始化方法
//Bean 的正常使用
//Bean 的销毁方法

