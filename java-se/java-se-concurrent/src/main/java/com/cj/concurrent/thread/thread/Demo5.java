package com.cj.concurrent.thread.thread;

public class Demo5 {
    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            System.out.println("hello, Thread A");
            Thread B = new Thread(() -> {
                System.out.println("hello, Thread B");
            });
            B.start();
            try {
                B.join(); // A 线程等待 B 线程执行完毕
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello again, Thread A");
        });
        A.start();

    }
}
//hello, Thread A
//hello, Thread B
//hello again, Thread A