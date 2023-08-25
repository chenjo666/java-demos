package com.cj.concurrent.thread.thread;

class PriorityExample implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}

public class Demo9 {
    public static void main(String[] args) {
        PriorityExample example = new PriorityExample();

        Thread t1 = new Thread(example);
        Thread t2 = new Thread(example);
        Thread t3 = new Thread(example);

        // 设置线程优先级
        t1.setPriority(Thread.MIN_PRIORITY);// 1
        t2.setPriority(Thread.NORM_PRIORITY);// 5
        t3.setPriority(Thread.MAX_PRIORITY);// 10

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
//Thread-2 is running
//Thread-0 is running
//Thread-1 is running