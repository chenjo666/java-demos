package com.cj.design_pattern.creational_05.singleton;

public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> singleton =
            ThreadLocal.withInitial(ThreadLocalSingleton::new);
    private ThreadLocalSingleton() {}
    public static ThreadLocalSingleton getInstance() {
        return singleton.get();
    }
}
