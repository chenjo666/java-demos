package com.cj.concurrent.thread.thread;

class YieldExample implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread.yield();// 让出 CPU 时间片
        }
    }
}
public class Demo8 {
    public static void main(String[] args) {
        YieldExample yieldExample = new YieldExample();
        Thread t1 = new Thread(yieldExample);
        Thread t2 = new Thread(yieldExample);
        t1.start();
        t2.start();
    }
}
//Thread-0 1
//Thread-1 1
//Thread-1 2
//Thread-0 2
//Thread-0 3
//Thread-1 3
//Thread-0 4
//Thread-1 4
//Thread-0 5
//Thread-1 5