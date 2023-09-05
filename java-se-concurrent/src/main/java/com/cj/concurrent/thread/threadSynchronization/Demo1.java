package com.cj.concurrent.thread.threadSynchronization;

class SynchronizedObject {
    private int count = 0;
    public void increment() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + " count: " + count);
            }
        }
    }
}

public class Demo1 {
    public static void main(String[] args) {
        SynchronizedObject s1 = new SynchronizedObject();
        SynchronizedObject s2 = new SynchronizedObject();
        new Thread(() -> s1.increment()).start();
        new Thread(() -> s2.increment()).start();
         new Object();
    }
}
