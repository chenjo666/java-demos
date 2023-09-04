package com.cj.concurrent.thread;

public class ThreadPriorityInheritableDemo {
    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
            Thread B = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
            });
            B.start();
        });
        A.setPriority(Thread.MAX_PRIORITY); //10
        A.start();
    }
}
//Thread-0 10
//Thread-1 10