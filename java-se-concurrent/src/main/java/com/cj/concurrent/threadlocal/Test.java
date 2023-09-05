package com.cj.concurrent.threadlocal;

public class Test {
    ThreadLocal<Object> threadLocal = ThreadLocal.withInitial(() -> new Object());
    public static void main(String[] args) {
        new ThreadLocal();
        new Thread();
        new InheritableThreadLocal<>();
    }
}
