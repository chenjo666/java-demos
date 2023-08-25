package com.cj.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

class Bean {}

public class ApplicationContextTests {
    public static void main(String[] args) {
        ApplicationContext classPathContext =
                new ClassPathXmlApplicationContext("SpringBeans.xml");
        ApplicationContext fileSystemContext =
                new FileSystemXmlApplicationContext("D:\\code-data\\java-demos\\spring\\src\\main\\resources\\SpringBeans.xml");

        Bean b1 = classPathContext.getBean("bean", Bean.class);
        Bean b2 = fileSystemContext.getBean("bean", Bean.class);
        Bean b3 = fileSystemContext.getBean("bean", Bean.class);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
//com.cj.spring.ioc.Bean@5dd6264
//com.cj.spring.ioc.Bean@1ffe63b9
//com.cj.spring.ioc.Bean@1ffe63b9
