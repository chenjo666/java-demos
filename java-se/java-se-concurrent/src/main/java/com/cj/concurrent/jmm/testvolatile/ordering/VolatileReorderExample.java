package com.cj.concurrent.jmm.testvolatile.ordering;

public class VolatileReorderExample {
    private volatile int x = 0;
    private volatile int y = 0;
    private volatile boolean flag = false;

    public void writer() {
        x = 1;       // 写操作1
        y = 2;       // 写操作2
        flag = true; // 写操作3
    }

    public void reader() {
        if (flag) {  // 读操作
            int sum = x + y; // 读操作4
            System.out.println("Sum: " + sum);
        }
    }
}

