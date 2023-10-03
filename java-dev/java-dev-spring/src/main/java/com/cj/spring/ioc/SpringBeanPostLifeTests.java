package com.cj.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class PostBeanLife {
    public PostBeanLife() {
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
class PostBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean 初始化之前的处理");
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean 初始化之后的处理");
        return bean;
    }
}
public class SpringBeanPostLifeTests {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        PostBeanLife bean = context.getBean("postBeanLife", PostBeanLife.class);
        System.out.println("Bean 的正常使用");
        context.close();
    }
}
//Bean 的构造方法
//Bean 的set方法
//Bean 初始化之前的处理
//Bean 的初始化方法
//Bean 初始化之后的处理
//Bean 的正常使用
//Bean 的销毁方法