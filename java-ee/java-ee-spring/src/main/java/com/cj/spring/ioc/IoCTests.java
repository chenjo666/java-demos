package com.cj.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

class IocBean {

}

public class IoCTests {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        context.getBean("ioc", IocBean.class);
//        BeanFactory

    }
}
