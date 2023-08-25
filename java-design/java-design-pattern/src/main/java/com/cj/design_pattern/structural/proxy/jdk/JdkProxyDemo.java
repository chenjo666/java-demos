package com.cj.design_pattern.structural.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//
interface UserService {
    void getUser(String id);
}
class UserServiceImpl implements UserService {

    @Override
    public void getUser(String id) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
//
interface BookService {
    void getBook(String id);
}
class BookServiceImpl implements BookService {

    @Override
    public void getBook(String id) {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

// 日志代理类
class LogProxy implements InvocationHandler {
    private Object object;

    public LogProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long t1 = System.currentTimeMillis();
        Object obj = method.invoke(this.object, args);
        System.out.println("耗时: " + (System.currentTimeMillis() - t1) + "ms");
        return obj;
    }
}

class ProxyFactory {
    public static Object getLogProxy(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), new LogProxy(object));
    }
}

public class JdkProxyDemo {
    public static void main(String[] args) {
        UserService userProxy = (UserService)ProxyFactory.getLogProxy(new UserServiceImpl());
        userProxy.getUser("1");

        BookService bookProxy = (BookService)ProxyFactory.getLogProxy(new BookServiceImpl());
        bookProxy.getBook("2");
    }
}
