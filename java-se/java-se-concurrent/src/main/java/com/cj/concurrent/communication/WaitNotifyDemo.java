package com.cj.concurrent.communication;

/**
 * 线程交替打印奇偶数
 */

public class WaitNotifyDemo {
    int num = 1;
    boolean s = false;
    public synchronized void printOdd() {
        if (s) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + (num++));
        s = true;
        notify();
    }
    public synchronized void printEven() {
        if (!s) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + (num++));
        s = false;
        notify();
    }
    public static void main(String[] args) {
        WaitNotifyDemo demo = new WaitNotifyDemo();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                demo.printOdd();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                demo.printEven();
            }
        }).start();
    }
}
//Thread-0: 1
//Thread-1: 2
//Thread-0: 3
//Thread-1: 4
//...