package com.cj.concurrent.threadlocal;

public class InheritableThreadLocalDemo {
    private static InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        threadLocal.set(1);
        System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        }).start();
    }
}
//main: 1
//Thread-0: 1