package com.cj.concurrent.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) {
        Thread blocker = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is blocked");
            LockSupport.park(); // 阻塞当前线程
            System.out.println(Thread.currentThread().getName() + " is unblocked");
        });
        blocker.start();

        try {
            Thread.sleep(2000); // 主线程睡眠2秒，确保blocker线程已经阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LockSupport.unpark(blocker); // 解除阻塞

        try {
            blocker.join(); // 等待blocker线程执行结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

