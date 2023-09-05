package com.cj.concurrent.threadlocal;

public class ThreadLocalDemo002 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        threadLocal.set(1);
        System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        }).start();
    }
}
//main: 1
//Thread-0: null