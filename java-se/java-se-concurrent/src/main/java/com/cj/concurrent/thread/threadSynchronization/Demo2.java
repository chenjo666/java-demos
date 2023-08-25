package com.cj.concurrent.thread.threadSynchronization;
class SynchronizedClass {
    private int count = 0;
    public void increment() {
        synchronized (SynchronizedClass.class) {
            for (int i = 0; i < 100; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + " count: " + count);
            }
        }
    }
}
public class Demo2 {
    public static void main(String[] args) {
        SynchronizedClass s1 = new SynchronizedClass();
        SynchronizedClass s2 = new SynchronizedClass();
        new Thread(() -> s1.increment()).start();
        new Thread(() -> s2.increment()).start();
    }
}
