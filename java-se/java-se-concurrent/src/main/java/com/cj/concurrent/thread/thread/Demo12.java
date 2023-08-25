package com.cj.concurrent.thread.thread;

class SynchronizedClass {
    private int count = 0;
    public void increment() {
        synchronized (this) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count: " + count);
        }
    }
}


public class Demo12 {

    public static void main(String[] args) {
        SynchronizedClass demo = new SynchronizedClass();
        SynchronizedClass demo2 = new SynchronizedClass();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.increment();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo2.increment();
            }
        }).start();
    }
}
