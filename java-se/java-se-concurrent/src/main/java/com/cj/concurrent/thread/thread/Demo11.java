package com.cj.concurrent.thread.thread;

class SynchronizedObject {
    private int count = 0;
    public void increment() {
        // 为当前对象上锁
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + " count: " + count);
            }
        }
    }
}


public class Demo11 {

    public static void main(String[] args) {
        SynchronizedObject demo = new SynchronizedObject();
        // 相同对象下吸同步
        new Thread(() -> {
            demo.increment();
        }).start();
        new Thread(() -> {
            demo.increment();
        }).start();
    }
}
//Thread-0 count: 1
//Thread-0 count: 2
//...
//Thread-0 count: 100
//Thread-1 count: 1
//Thread-1 count: 2
//...
//Thread-1 count: 100