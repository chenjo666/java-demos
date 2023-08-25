package com.cj.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean init...");
    }
}

public class SingletonBeanTests {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

        SingletonBean singletonBean1 = context.getBean("singletonBean", SingletonBean.class);
        SingletonBean singletonBean2 = context.getBean("singletonBean", SingletonBean.class);

        System.out.println(singletonBean1);
        System.out.println(singletonBean2);
    }
}
//SingletonBean init...
//com.cj.spring.ioc.SingletonBean@4c1d9d4b
//com.cj.spring.ioc.SingletonBean@4c1d9d4b
